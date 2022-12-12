package com.Service.impl;

import com.Mapper.AdminUserMapper;
import com.Service.AdminUserService;
import com.Utils.JwtUtil;
import com.entiy.AdminUser;
import com.entiy.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AdminUserServiceimpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public void updateTokenUser(int id) {

    }

    @Override
    public String updateUserByid(User user) {

        try {
            adminUserMapper.updateUserByid(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    @Override
    public PageInfo<User> GetAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users=adminUserMapper.getAllPages();
        PageInfo<User> userPageInfo = new PageInfo<>(users);


        return userPageInfo;
    }

    @Override
    public Map login(AdminUser adminUser) {
        String id = adminUserMapper.login(adminUser);

        if (id!=null){
            //登陆成功
            //生成token


            //准备存放在IWT中的自定义数据
            Map<String, Object> info = new HashMap<>();
            info.put("username", adminUser.getAccount());
            info.put("pass", adminUser.getPsd());
            info.put("userType","admin");//定义登陆类型为admin
            //生成JWT字符串
            String token = JwtUtil.sign(id, info);
            //保存Token
            adminUser.setId(Integer.valueOf(id));
            System.out.println(adminUser);

            //获取时间
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(date);
            adminUser.setLastlogintime(time);

            adminUser.setToken(token);
            try {
               adminUserMapper.updateTokenUser(adminUser);
            } catch (Exception e) {
                System.out.println("token更新出错"+e);
            }

            Map map=new HashMap<>();
            map.put("token",token);
            map.put("userId",id);

            map.put("currenTime",time);

            return map;//成功返回token 和id的 map


        }

        return null;
    }
}
