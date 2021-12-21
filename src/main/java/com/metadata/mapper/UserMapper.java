package com.metadata.mapper;

import com.metadata.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface UserMapper {
    List<User> queryUserList();

    /***
     * 根据用户名获取用户的全部资料
     * @param username
     * @return 如果找到返回对象，反之返回null
     */
    User getByUsername(String username);

    /**
     * 更新用户的数据信息
     * @param user 用户的数据
     * @return 返回受影响的行数
     */
    int updateInfoByUsername(User user);
}
