package com.metadata.controller;

import com.metadata.common.dto.UserFillingDto;
import com.metadata.common.lang.Result;
import com.metadata.entity.User;
import com.metadata.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 通过用户 id 查询用户个人的资料
     *
     * @param id 用户 id
     * @return user对象
     */
    @GetMapping("info")
    @RequiresAuthentication
    public Result getUserInfo(@RequestParam(name = "id") int id) {
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    /**
     * 通过用户对象更新用户个人的资料
     *
     * @param user user对象
     * @return null
     */
    @PutMapping("info")
    public Result updateUserInfo(@RequestBody User user) {
        userService.updateUser(user);
        return Result.success(user);
    }

    /**
     * 获取用户所填写项目和教材
     *
     * @param id 用户 id
     * @return 泛对象
     */
    @GetMapping("batches")
    @RequiresAuthentication
    public Result getMyFillings(@RequestParam(name = "id") int id) {
        UserFillingDto userFillingDto = userService.getUserAllFillings(id);
        return Result.success(userFillingDto);
    }
}
