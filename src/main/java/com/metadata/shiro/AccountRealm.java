package com.metadata.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.metadata.entity.User;
import com.metadata.service.UserService;
import com.metadata.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    // 需要判断这个 token 是 jwt 的 token，而不是其他 token
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    // 获取一个用户的权限，然后封装成一个 info 返回给 shiro
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    // 获取 token 之后进行密码校验等等逻辑，校验成功后返回基本信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;   // 已经获得了 jwt

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(Integer.parseInt(userId));

        // 用户不存在
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        // 用户被锁
        if (user.getIdentify() == -1) {
            throw new LockedAccountException("账户已被锁定");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        // 权限、凭证、域名
        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}
