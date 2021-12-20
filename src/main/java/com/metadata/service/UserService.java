package com.metadata.service;

import com.metadata.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User getById(String username);

    public User getByUsername(String username);

    public User create(String username, String password);
}
