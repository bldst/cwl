package com.Service.impl;

import com.Mapper.ManagerUserMapper;
import com.Service.ManageUserServicer;
import com.config.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entiy.DeviceWITHadmin;
import com.entiy.User;
import com.entiy.manageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagerUserServiceimpl implements ManageUserServicer {
    @Autowired
    private ManagerUserMapper managerUserMapper;
    @Resource
    RedisTemplate redisTemplate;
    @Override
    public Map login(manageUser user) {
        QueryWrapper<manageUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",user.getAccount()).eq("psd",user.getPsd());
        manageUser res_user = managerUserMapper.selectOne(queryWrapper);
        if (res_user.getId()!=null){
//            redisTemplate.opsForValue().set();
            //准备存放在IWT中的自定义数据

            Map<String, Object> info = new HashMap<>();
            info.put("username", user.getAccount());
            info.put("pass", user.getPsd());
            info.put("userType", "user");//定义登陆类型为user
            //生成JWT字符串

            String token = JwtUtil.sign(String.valueOf(res_user.getId()) , info);
            //保存Token
            res_user.setToken(token);
            Map<String,String> res=new HashMap<>();
            res.put("userid",String.valueOf(res_user.getId()));
            res.put("token",res_user.getToken());
            //保存token到redis
            assert token != null;
            redisTemplate.opsForValue().set("token"+String.valueOf(res_user.getId()),token);
            return res;
        }
        return null;
    }

    @Override
    public boolean logout(String token) {
        //注销 删除redis缓存中的token

        try {
            String id = JwtUtil.getUserId(token);
            redisTemplate.delete("token"+id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<DeviceWITHadmin> selectdevicebyadminid(String id) {
        List<DeviceWITHadmin> res = managerUserMapper.find1(id);
        return res;
    }
}
