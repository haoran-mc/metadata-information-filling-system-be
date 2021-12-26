package com.metadata.service;

import com.metadata.common.dto.UserFillingDto;
import com.metadata.entity.User;


public interface UserService {
    /**
     * 通过用户id查询用户个人的资料service
     *
     * @param id 用户 id
     * @return user对象
     */
    User getUserById(int id);

    /**
     * 通过手机号查询用户
     * @param phone 手机号码
     * @return 一个用户
     */
    User getUserByPhone(String phone);

    /**
     * 注册
     * @param phone 电话
     * @param username 用户名
     * @param password 密码
     * @return 创建的用户
     */
    User createUser(String phone, String username, String password);

    /**
     * 通过用户对象更新用户个人的资料service
     *
     * @param user user对象
     */
    void updateUser(User user);

    /**
     * 获取用户所填写项目或书籍的详细信息service
     *
     * @param id 用户 id
     * @return 泛对象
     */
    Object getUserBatches(String phone, int category);
}
