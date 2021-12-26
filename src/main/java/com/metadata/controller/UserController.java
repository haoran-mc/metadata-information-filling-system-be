package com.metadata.controller;

import com.metadata.common.lang.Result;
import com.metadata.entity.User;
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

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 通过用户 id 查询用户个人的资料
     *
     * @param id 用户 id
     * @return user对象
     */
    @GetMapping("info")
    public Result getUserInfo(@RequestParam(name = "userPhone") String userPhone) {
        //参数可写HttpServletRequest request
        //String userPhone = request.getParameter("userPhone");
        User data = userService.getUserByPhone(userPhone);
        return Result.success(data);
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
        return Result.success(null);
    }

    /**
     * 获取用户所填写项目和教材
     *
     * @param id 用户 id
     * @return 泛对象
     */
    @GetMapping("batches")
    public Result getMyFilling(@RequestParam(name = "userPhone") String userPhone,
                               @RequestParam(name = "category") int category) {
        Object obj = userService.getUserBatches(userPhone, category);
        return Result.success(obj);
    }
}
