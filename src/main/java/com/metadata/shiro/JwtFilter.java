package com.metadata.shiro;

import cn.hutool.json.JSONUtil;
import com.metadata.common.lang.Result;
import com.metadata.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 继承 shiro 内置的过滤器 AuthenticatingFilter
 * jwtFilter 根据是否有 jwt 判断是否经过 shiro 处理
 */
@Component
public class JwtFilter extends AuthenticatingFilter {
    @Autowired
    JwtUtils jwtUtils;

    // 获取 jwt 后需要拿给 shiro 处理，shiro 处理的是 token 的形式，所以我们需要将 jwt 包装成 token
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        // 我们的 jwt 是放在头部的，强转之后拿到 jwt
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String jwt = request.getHeader("Authorization");

        // jwt 不能为空
        if (StringUtils.isEmpty(jwt))
            return null;
        // 不为空就生成一个 jwtToken 对象
        return new JwtToken(jwt);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest,
                                     ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取 jwt
        String jwt = request.getHeader("Authorization");

        if (StringUtils.isEmpty(jwt)) {
            return true;   // 如果没有 jwt，就不需要 shiro 注解处理，直接到 controller
        } else {
            // 拿到 jwt 中存储的信息，校验 jwt，判断 jwt 是否过期、错误等
            Claims claim = jwtUtils.getClaimByToken(jwt);
            if (claim == null || jwtUtils.isTokenExpired(claim.getExpiration())) {
                throw new ExpiredCredentialsException("token 失效，请重新登录");
            }

            // 执行登录
            // AuthenticatingFilter.executeLogin
            // -> subject.login(token)
            // -> AccountRealm.AuthenticationInfo
            return executeLogin(servletRequest, servletResponse);
        }
    }

    // 重写 onLoginFailure 方法，因为返回数据自定义为 Result 了
    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e,
                                     ServletRequest request,
                                     ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 获取错误的原因
        Throwable throwable = e.getCause() == null ? e : e.getCause();

        Result result = Result.fail(throwable.getMessage());

        String json = JSONUtil.toJsonStr(result);   // 使用 hutool 工具

        try {
            httpServletResponse.getWriter().print(json);
        } catch (IOException ioException) {
            // ioException.printStackTrace();
        }
        return false;
    }

    // 对跨域提供支持
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(org.springframework.http.HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
