package com.metadata.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterDto {
    @NotBlank(message = "电话不能为空")
    private String phone;

    @NotBlank(message = "密码不能为空")
    private String password;
}