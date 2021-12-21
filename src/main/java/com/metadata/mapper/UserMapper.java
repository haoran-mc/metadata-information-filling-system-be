package com.metadata.mapper;

import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 通过用户手机号查询用户个人的资料mapper
     * @param phone 手机号
     * @return user对象
     */
    User getUserByPhone(String phone);

    /**
     * 通过用户对象更新用户个人的资料mapper
     * @param phone 手机号
     * @param username 用户名
     * @param password 密码
     */
    void updateUserByPhone(String phone, String username, String password);

    /**
     * 获取用户所填写项目的详细信息mapper
     * @param phone 手机号
     * @return project对象
     */
    Project getUserBatchProject(String phone);

    /**
     * 获取用户所填写书籍的详细信息mapper
     * @param phone 手机号
     * @return textbook对象
     */
    Textbook getUserBatchTextbook(String phone);
}