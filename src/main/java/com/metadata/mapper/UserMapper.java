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
    User getUserByPhone(String phone);

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
    Project getUserProject(String phone);

    /**
     * 获取用户所填写书籍的详细信息
     * @param id 用户 id
     * @return textbook对象
     */
    Textbook getUserTextbook(String phone);
}