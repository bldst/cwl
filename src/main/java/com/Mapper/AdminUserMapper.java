package com.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entiy.AdminUser;
import com.entiy.User;
import com.entiy.joinMatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminUserMapper extends BaseMapper<User> {
    String login(AdminUser adminUser);
    void updateTokenUser(AdminUser adminUser);
    void updateUserByid(User user);
}
