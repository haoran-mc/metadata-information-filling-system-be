package com.metadata.SaToken;

import cn.dev33.satoken.stp.StpInterface;
import com.metadata.entity.User;
import com.metadata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    UserService userService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        User user = userService.getUserById((int)loginId);

        System.out.println("role: " + user.getRole());

        List<String> list = new ArrayList<String>();

        list.add(user.getRole());
        return list;
    }
}
