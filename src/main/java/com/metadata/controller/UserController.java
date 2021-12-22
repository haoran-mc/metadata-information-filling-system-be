package com.metadata.controller;

import com.metadata.common.lang.Result;
import com.metadata.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("info")
    // 获取个人信息
    public Result getUserInfo() {
        return null;
    }

    @PutMapping("info")
    // 更新个人信息
    public Result updateUserInfo() {
        return null;
    }

    @GetMapping("batches")
    // 获取我的填报
    public Result getMyFilling() {
        return null;
    }
}
