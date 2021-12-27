package com.metadata.controller;

import com.metadata.common.dto.UserFillingDto;
import com.metadata.common.lang.Result;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.entity.User;
import com.metadata.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户类接口")
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
    @ApiOperation("获取用户个人资料的接口") //controller层swagger注释示例
    @GetMapping("info")
    public Result getUserInfo(@ApiParam("前端传来用户手机号码") @RequestParam(name = "userPhone") String userPhone) {
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
     * @param id 用户 id
     * @return project/textbook对象
     */
    @GetMapping("batches")
    public Result getMyFilling(@RequestParam(name = "id") int id) {
        UserFillingDto userFillingDto = userService.getUserAllFillings(id);
        return Result.success(userFillingDto);
    }
}
