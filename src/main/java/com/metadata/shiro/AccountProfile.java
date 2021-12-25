package com.metadata.shiro;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {
    private String phone;

    private String username;

    private String nickname;
    // private int identify;
}
