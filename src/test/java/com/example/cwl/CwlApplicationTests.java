package com.example.cwl;

import com.Mapper.AdminUserMapper;
import com.Mapper.UserMapper;
import com.entiy.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

class CwlApplicationTests {


  @Autowired
    UserMapper userMapper;
  @Test
    public void getallpage(){
      PageHelper.startPage(1,3);
      List<User> users=userMapper.selectList(null);
      PageInfo<User> userPageInfo = new PageInfo<>(users);
      System.out.println(userPageInfo);
  }
}
