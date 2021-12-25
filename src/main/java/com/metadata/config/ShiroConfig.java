package com.metadata.config;

import com.metadata.shiro.AccountRealm;
import com.metadata.shiro.JwtFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    JwtFilter jwtFilter;

    // 使用 redis
    @Bean
    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

        // inject redisSessionDAO
        sessionManager.setSessionDAO(redisSessionDAO);

        // other stuff...

        return sessionManager;
    }

    // 重写了 realm，所以需要重写 SessionSecurityManager 和 SessionManager
    @Bean
    public SessionsSecurityManager securityManager(AccountRealm accountRealm,
                                                   SessionManager sessionManager,
                                                   RedisCacheManager redisCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(accountRealm);

        // inject sessionManager
        securityManager.setSessionManager(sessionManager);

        // inject redisCacheManager
        securityManager.setCacheManager(redisCacheManager);

        // other stuff...

        return securityManager;
    }

    /**
     * shiro 过滤器链，定义哪些链接经过哪些过滤器
     * 比如 /batches 需要经过 authc 的过滤器
     * 但是我们这里让所有的链接都经过 jwt 过滤器，jwt 过滤器在下面被指定是 jwtFilter
     * jwtFilter 时自定义的过滤器
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        // 使用 jwt 拦截，jwt 不是 shiro 默认的，需要自己配置
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 所有的链接都需要经过 jwt 过滤器
        filterMap.put("/**", "jwt");
        chainDefinition.addPathDefinitions(filterMap);
        return chainDefinition;
    }

    // 拦截器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
                                                         ShiroFilterChainDefinition shiroFilterChainDefinition) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilter.setSecurityManager(securityManager);

        Map<String, Filter> filters = new HashMap<>();
        /** shiro 的内置过滤器：
         * anon: 无需认证就可访问
         * authc: 必须认证才能访问
         * user: 必须拥有记住我才能用
         * perms: 必须拥有对某个资源的权限才能访问
         * role: 拥有某个角色权限才能访问
         *
         * 我们没有使用 shiro 内置的过滤器，自己配置一个 jwtFilter
         */
        filters.put("jwt", jwtFilter);
        shiroFilter.setFilters(filters);


        Map<String, String> filterMap = shiroFilterChainDefinition.getFilterChainMap();

        shiroFilter.setFilterChainDefinitionMap(filterMap);

        // 设置登录请求
        // shiroFilter.setLoginUrl("/toLogin");
        // 未授权的页面，所以我们还需要一个未授权的页面
        shiroFilter.setUnauthorizedUrl("/noauth");

        return shiroFilter;
    }
}
