package com.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entiy.DeviceWITHadmin;
import com.entiy.User;
import com.entiy.manageUser;

import java.util.List;

public interface ManagerUserMapper extends BaseMapper <manageUser> {
    List<DeviceWITHadmin> find1(String id);

}
