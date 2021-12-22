package com.metadata.service.impl;

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
    public User getById(String phone) {
        User user = getByPhone(phone);
        return user;
    }

    @Override
    public User getByPhone(String phone) {
        User user = userMapper.getUserByPhone(phone);
        return user;
    }

    @Override
    public User create(String username, String password) {
        return null;
    }
}
