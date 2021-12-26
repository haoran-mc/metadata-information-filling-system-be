package com.metadata.mapper;

import com.metadata.common.dto.UserFillingDto;
import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.entity.User;
import com.metadata.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 通过用户 id 查询用户个人的资料
     * @param id 用户 id
     * @return user对象
     */
    User getUserById(@Param("id") int id);

    /**
     * 通过手机号码查询用户
     * @param phone 手机号码
     * @return 一个用户
     */
    User getUserByPhone(@Param("phone") String phone);

    /**
     * 注册
     * @param phone 电话
     * @param username 用户名
     * @param password 密码
     */
    void createUser(
            @Param("phone") String phone,
            @Param("username") String username,
            @Param("password") String password
    );

    /**
     * 通过用户对象更新用户个人的资料
     * @param user user对象
     */
    void updateUser(@Param("user") User user);

    /**
     * 获取用户所填写项目的详细信息
     * @param id 用户 id
     * @return project对象
     */
    Project getUserProject(@Param("id") int id);

    /**
     * 获取用户所填写书籍的详细信息
     * @param id 用户 id
     * @return textbook对象
     */
    Textbook getUserTextbook(@Param("id") int id);
}