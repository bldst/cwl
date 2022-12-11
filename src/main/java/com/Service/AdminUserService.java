package com.Service;

import com.entiy.AdminUser;
import com.entiy.User;

import java.util.Map;

public interface AdminUserService {

    Map login(AdminUser adminUser);
    void updateTokenUser(int id);
    String updateUserByid(User user);
}
