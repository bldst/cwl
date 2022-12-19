package com.example.cwl;


import com.Mapper.ManagerUserMapper;

import com.entiy.DeviceWITHadmin;
import com.entiy.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest

class CwlApplicationTests {



  @Autowired
  private ManagerUserMapper managerUserMapper;
  @Autowired
  private RedisTemplate redisTemplate;


  @Test
  public void redis(){
    String userId="618803202";
    Object o = redisTemplate.opsForValue().get("token" + userId);
    System.out.println(o);
  }

  @Test
  public void fin1(){
    List<DeviceWITHadmin> managerUserMapper1 = managerUserMapper.find1(String.valueOf(71));
    System.out.println(managerUserMapper1);
  }
}
