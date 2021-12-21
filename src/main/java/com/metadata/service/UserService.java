package com.metadata.service;

import com.metadata.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User getById(String phone);

    public User getByPhone(String phone);

    public User create(String phone, String password);
}
