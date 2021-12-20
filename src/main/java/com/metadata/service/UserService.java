package com.metadata.service;

import com.metadata.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User getById(int id);
    public List<User> getAllUsers();
}
