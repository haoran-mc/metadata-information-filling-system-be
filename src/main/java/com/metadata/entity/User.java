package com.metadata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体")
public class User {
    @ApiModelProperty("用户id")
    int id;
    @ApiModelProperty("用户手机号码")
    String phone;
    @ApiModelProperty("用户密码")
    String password;
    @ApiModelProperty("用户昵称")
    String username;
    @ApiModelProperty("用户权限")
    String role;   // super_admin, admin, user
}
