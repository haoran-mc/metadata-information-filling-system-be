package com.metadata.service;

import com.metadata.entity.Project;
import com.metadata.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User getById(String phone);
    public User create(String phone, String password);
    /**
     * 通过用户手机号查询用户个人的资料service
     * @param phone 手机号
     * @return user对象
     */
    User getUserByPhoneS(String phone);

    /**
     * 通过用户对象更新用户个人的资料service
     * @param user user对象
     */
    void updateUserByPhoneS(User user);

    /**
     * 获取用户所填写项目或书籍的详细信息service
     * @param phone 手机号
     * @param category 类型
     * @return 泛对象
     */
    Object getUserBatchByCategory(String phone, int category);


}
