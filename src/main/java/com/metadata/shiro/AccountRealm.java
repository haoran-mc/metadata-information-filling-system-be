package com.metadata.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.metadata.entity.User;
import com.metadata.service.UserService;
import com.metadata.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
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

    // 认证，获取 token 之后进行密码校验等等逻辑，校验成功后返回基本信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;   // 已经获得了 jwt

        // 获取 userId
        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        // 查出用户
        User user = userService.getUserById(Integer.parseInt(userId));

        // 用户不存在
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        // 权限、凭证、域名
        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }

    // 授权，获取一个用户的权限，然后封装成一个 info 返回给 shiro
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        info.addStringPermission(currentUser.getRole());

        return info;
    }
}
