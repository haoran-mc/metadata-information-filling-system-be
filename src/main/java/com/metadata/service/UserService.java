package com.metadata.service;

import com.metadata.entity.User;


public interface UserService {
    /**
     * 通过用户id查询用户个人的资料service
     * @param id 用户 id
     * @return user对象
     */
    User getById(int id);

    /**
     * 用户注册service
     * @param phone 手机号
     * @param password 密码
     * @return user对象
     */
    User create(String phone, String password);

    /**
     * 通过用户手机号查询用户个人的资料service
     * @param phone 手机号
     * @return user对象
     */
    User getUserByPhone(String phone);

    /**
     * 通过用户对象更新用户个人的资料service
     * @param user user对象
     */
    void updateUser(User user);

    /**
     * 获取用户所填写项目或书籍的详细信息service
     * @param phone 手机号
     * @param category 类型
     * @return 泛对象
     */
    Object getUserBatches(String phone, int category);
}
