package com.metadata.service.impl;

import com.metadata.entity.Project;
import com.metadata.entity.Textbook;
import com.metadata.entity.User;
import com.metadata.mapper.UserMapper;
import com.metadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 通过用户id查询用户个人的资料impl
     *
     * @param id 用户 id
     * @return user对象
     */
    @Override
    public User getById(int id) {
        User user = getById(id);
        return user;
    }

    /**
     * 用户注册impl
     * @param username 用户名
     * @param password 密码
     * @return 返回创建的用户
     */
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
    public User getUserByPhone(String phone) {
        User result = userMapper.getUserByPhone(phone);
        User user = new User();
        user.setPhone(result.getPhone());
        user.setUsername(result.getUsername());
        user.setPassword(result.getPassword());
        user.setRole(result.getRole());
        return user;
    }

    /**
     * 通过用户对象更新用户个人的资料impl
     *
     * @param user user对象
     */
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    /**
     * 获取用户所填写项目或书籍的详细信息impl
     *
     * @param id 用户 id
     * @return 泛对象
     */
    @Override
    public Object getUserBatches(String phone, int category) {

        if(category == 1){
            Project pj = userMapper.getUserProject(phone);
            return pj;
        }else if(category == 2){
            Textbook tb = userMapper.getUserTextbook(phone);
            return tb;
        }else {
            try {
                throw new Exception("类型参数出错");  //这里异常需要新建一个异常类CategoryException处理
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
