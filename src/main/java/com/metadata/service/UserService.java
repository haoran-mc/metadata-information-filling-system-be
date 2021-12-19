package com.metadata.service;

import com.metadata.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User getById(int id);
}
