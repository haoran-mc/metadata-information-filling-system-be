package com.metadata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    int id;
    String phone;
    String password;
    String username;
    String Role;   // super_admin, admin, user
}
