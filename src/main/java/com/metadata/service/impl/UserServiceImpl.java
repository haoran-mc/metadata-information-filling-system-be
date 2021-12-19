package com.metadata.service.impl;

import com.metadata.entity.User;
import com.metadata.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public User getById(int id) {
        User user = new User();
        return user;
    }
}
