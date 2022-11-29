package com.Service.impl;

import com.Mapper.UserMapper;
import com.Service.UserService;
import com.User.User;
import com.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User get(Integer id) {
        return userMapper.get(id);
    }

    @Override
    public User getByAccount(String account) {
        return userMapper.getByAccount(account);

    }

    @Override
    public void updateTokenUser(User user) {
        userMapper.updateTokenUser(user);
    }

    //注册
    @Override
    public String Register(User user) {
       if (userMapper.getByAccount(user.getAccount())==null){
           int i = user.getPsd().matches(".*\\d+.*") ? 1 : 0;
           int j = user.getPsd().matches(".*[a-zA-Z]+.*") ? 1 : 0;
           int l = user.getPsd().length();
           if (i==1&&j==1&&l>5)
           {
               userMapper.insert(user);
               return "1";
           }
         return "0";
    }

        return "注册失败，账号已存在";
    }
                //登陆
    @Override
    public String login(User user) {
        Integer id = Integer.valueOf(userMapper.login(user));
        if (id!=null){
            //生成token
            String userId = String.valueOf(id);

            //准备存放在IWT中的自定义数据
            Map<String, Object> info = new HashMap<>();
            info.put("username", user.getAccount());
            info.put("pass", user.getPsd());

            //生成JWT字符串
            String token = JwtUtil.sign(userId, info);
            //保存Token
            user.setId(id);
            System.out.println(user);
            user.setToken(token);
            try {
                userMapper.updateTokenUser(user);
            } catch (Exception e) {
                System.out.println("token更新出错"+e);
            }

            return token;//成功返回token
        }
        return null;//失败返回null
    }

    @Override
    public String CheckToken(HttpServletRequest request) {
        return null;
    }

    @Override
//    用户注销，设置数据库对应token为空
    public void LogoutUser(String token) {
        try {
            userMapper.LogoutUser(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
