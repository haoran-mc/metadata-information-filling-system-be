package com.metadata.controller;

import com.metadata.common.lang.Result;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
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
     * 通过用户手机号查询用户个人的资料
     * @param userPhone 手机号
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
     * @param user user对象
     * @return null
     */
    @PutMapping("info")
    public Result updateUserInfo(@RequestBody User user) {
        userService.updateUser(user);
        return Result.success(null);
    }


    /**
     * 获取用户所填写书籍的详细信息
     * @param userPhone 手机号
     * @param category 种类
     * @return project/textbook对象
     */
    @GetMapping("batches")
    public Result getMyFilling(@RequestParam(name = "userPhone") String userPhone,
                               @RequestParam(name = "category") String category) {
        if(category == "project"){
            Project project = userService.getUserProject(userPhone);
            return Result.success(project);
        }else if (category == "textbook"){
            Textbook textbook = userService.getUserTextbook(userPhone);
            return Result.success(textbook);
        }
        return Result.fail("category不合法！");
    }
}
