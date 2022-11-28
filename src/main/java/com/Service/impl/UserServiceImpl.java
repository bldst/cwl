package com.Service.impl;

import com.Mapper.UserMapper;
import com.Service.UserService;
import com.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Integer login(User user) {

        if (userMapper.login(user)!=null){
            return 1;
        }
        return 0;//失败返回0
    }


}
