package com.metadata.util;

import com.metadata.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {
    // 获取用户
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
