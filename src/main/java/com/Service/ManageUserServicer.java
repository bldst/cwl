package com.Service;

import com.entiy.DeviceWITHadmin;
import com.entiy.User;
import com.entiy.manageUser;

import java.util.List;
import java.util.Map;

public interface ManageUserServicer {
    Map login(manageUser user);
    boolean logout(String token);
    List<DeviceWITHadmin> selectdevicebyadminid(String id);
}
