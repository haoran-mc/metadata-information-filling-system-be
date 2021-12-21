package com.metadata.service.impl;

import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.entity.User;
import com.metadata.mapper.UserMapper;
import com.metadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getById(String Phone) {
        User user = new User();
        return user;
    }

    @Override
    public User create(String username, String password) {
        return null;
    }

    /**
     * 通过用户手机号查询用户个人的资料impl
     * @param phone 手机号
     * @return user对象
     */
    @Override
    public User getUserByPhoneS(String phone) {
        User result = userMapper.getUserByPhone(phone);
        /*用户不存在的异常
        if (result == null) {
            try {
                throw new Exception("用户数据不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         */
        User user = new User();
        user.setPhone(result.getPhone());
        user.setUsername(result.getUsername());
        user.setPassword(result.getPassword());
        user.setIdentify(result.getIdentify());
        return user;
    }

    /**
     * 通过用户对象更新用户个人的资料impl
     * @param user
     */
    @Override
    public void updateUserByPhoneS(User user) {
        /*用户不存在的异常
        User result = userMapper.getUserByPhone(user.getPhone());
        if (result == null) {
            try {
                throw new Exception("用户数据不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         */
        userMapper.updateUserByPhone(user.getPhone(), user.getUsername(), user.getPassword());
    }

    /**
     * 获取用户所填写项目或书籍的详细信息impl
     * @param phone 手机号
     * @param category 类型
     * @return 泛对象
     */
    @Override
    public Object getUserBatchByCategory(String phone, int category) {
        /*用户不存在的异常
        User result = userMapper.getUserByPhone(phone);
        if (result == null) {
            try {
                throw new Exception("用户数据不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         */
        if(category == 1){
            Project pj = userMapper.getUserBatchProject(phone);
            return pj;
        }else if(category == 2){
            Textbook tb = userMapper.getUserBatchTextbook(phone);
            return tb;
        }else {
            try {
                throw new Exception("类型参数出错");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
