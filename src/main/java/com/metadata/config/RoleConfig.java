package com.metadata.config;

import lombok.Data;

@Data
public class RoleConfig {
    private String super_admin;
    private String admin;
    private String user;
}
