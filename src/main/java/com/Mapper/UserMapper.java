package com.Mapper;

import com.User.User;
import com.User.joinMatch;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("select account from User where account=#{account}")
//    String selectByAccount(String account);
//    @Select("select * from User where account=#{account} and psd=#{psd}")
//    String  selectOne(User user);

        User selectOne(User user);
        User get(Integer id);
        User getByAccount(String account);
        String login(User user);
         void updateTokenUser(User user);
        String selectByAccount(@Param("account") String account);
        void LogoutUser(String token);
        boolean selectTokenString (String token);
        void updatePsd(User user);
        boolean joinMatch(joinMatch joinMatch);
        boolean outMatch(joinMatch joinMatch);
        List<joinMatch> getMatchid(joinMatch joinMatch);
}
