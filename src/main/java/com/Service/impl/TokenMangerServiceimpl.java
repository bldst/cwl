package com.Service.impl;

import com.Service.TokenMangerService;
import com.config.JwtUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class TokenMangerServiceimpl implements TokenMangerService {
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean CheckToken(String token) {

        String userId = JwtUtil.getUserId(token);
        String key="token"+userId;
        System.out.println("redis的"+key);
        //从redis获得token进行匹配
        Object obj = redisTemplate.opsForValue().get(key);
        System.out.println("从redis获得的token是"+obj);
//            assert s != null;
        if (!Objects.equals(obj, token)){

            return false;
        }

        return true;
    }
}
