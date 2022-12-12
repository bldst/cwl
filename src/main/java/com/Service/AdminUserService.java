package com.Service;

import com.entiy.AdminUser;
import com.entiy.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AdminUserService {

    Map login(AdminUser adminUser);
    void updateTokenUser(int id);
    String updateUserByid(User user);
    //分页查询
    PageInfo<User> GetAll(Integer pageNum, Integer pageSize);
}
