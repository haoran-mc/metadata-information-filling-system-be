package com.metadata.service.impl;

import com.metadata.entity.User;
import com.metadata.mapper.UserMapper;
import com.metadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getById(int id) {
        User user = new User();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.queryUserList();
    }
}
