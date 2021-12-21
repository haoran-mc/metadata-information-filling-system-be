package com.metadata.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.metadata.common.dto.LoginDto;
import com.metadata.common.dto.RegisterDto;
import com.metadata.common.lang.Result;
import com.metadata.entity.User;
import com.metadata.service.UserService;
import com.metadata.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        User user = userService.getById(loginDto.getPhone());

        Assert.notNull(user, "用户不存在");

        if (user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.fail("密码不正确");
        }

        String jwt = jwtUtils.generateToken(user.getUsername());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.success(MapUtil.builder()
                .put("phone", user.getPhone())
                .put("username", user.getUsername())
                .map()
        );
    }

    @PostMapping("register")
    public Result register(@Validated @RequestBody RegisterDto registerDto, HttpServletResponse response) {
        User user = userService.create(registerDto.getPhone(), SecureUtil.md5(registerDto.getPassword()));

        // TODO 是否需要判断插入不成功

        String jwt = jwtUtils.generateToken(user.getUsername());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.success(MapUtil.builder()
                .put("phone", user.getPhone())
                .put("username", user.getUsername())
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("logout")
    public Result logout() {
        // 交给 shiro 来退出
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }
}
