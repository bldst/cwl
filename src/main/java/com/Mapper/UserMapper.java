package com.Mapper;

import com.User.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("select account from User where account=#{account}")
//    String selectByAccount(String account);
//    @Select("select * from User where account=#{account} and psd=#{psd}")
//    String  selectOne(User user);

        User selectOne(User user);
        User get(Integer id);
        User getByAccount(String account);
        Integer login(User user);

         String selectByAccount(@Param("account") String account);
}
