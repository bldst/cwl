package com.Controller;

import com.Mapper.UserMapper;
import com.Service.UserService;
import com.User.User;
import com.Utils.JwtUtil;
import com.Utils.ResultMsg;
import com.Utils.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/index")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

//    @PutMapping("/register")
//    private String register(User user) {
//
//
//        if (userMapper.selectByAccount(user.getAccount()) == null) {
//
//            userMapper.insert(user);
//            return "注册成功";
//        }
//        return "账号已存在";
//    }

//    @GetMapping("/login")
//    private User login(User user) {
//
//
//        if (userMapper.selectOne(user) == null) {
//            return user;
//        }
//        return userMapper.selectOne(user);
//
//    }


    @GetMapping("/{id}")
    ResultMsg get(@PathVariable Integer id) {

        return ResultMsg.ok(ResultStatusEnum.SUCCESS, userService.get(id));
    }

    @GetMapping("/getaccount/{account}")
    ResultMsg getByaccount(@PathVariable String account) {
        return ResultMsg.ok(ResultStatusEnum.SUCCESS, userService.getByAccount(account));

    }

    @PutMapping("/register")
    ResultMsg Register(User user) {
        try {
            String action = userService.Register(user);
            if (action == "1")//注册成功
            {
                return ResultMsg.ok(ResultStatusEnum.register_SUCCESS, "注册成功");
            }

            if (action == "0")//密码不符合规则
            {
                return ResultMsg.ok(ResultStatusEnum.ERROR, "密码需要英文和数字且不少于6位");
            }

            return ResultMsg.ok(ResultStatusEnum.ERROR, "账号已存在");


        } catch (Exception e) {
            return ResultMsg.error(ResultStatusEnum.ERROR, String.valueOf(e));
        }
    }

    @GetMapping("/login")
    ResultMsg Login(User user) {
        try {
            String aciton = userService.login(user);//如果token校验不通过，返回值为空，触发异常


            return ResultMsg.ok(ResultStatusEnum.Login_SUCCESS, aciton);//登陆成功返回Token


        } catch (Exception e) {
            return ResultMsg.error(ResultStatusEnum.Login_ERROR, "请检查账号密码");
        }
    }

    @GetMapping("/Token")
    public String testToken(String username, String pass) {
        String userId = UUID.randomUUID().toString();

        //准备存放在IWT中的自定义数据
        Map<String, Object> info = new HashMap<>();
        info.put("username", "tom");
        info.put("pass", "admin");

        //生成JWT字符串
        String token = JwtUtil.sign(userId, info);

        return "token:" + token;
    }

    @GetMapping("/CheckToken")
    public String CheckToken(HttpServletRequest request) {


        return "true";
    }

    @RequestMapping("/admin/token")
    public void AdminLoginToken(@RequestParam("account")String name,@RequestParam("psd") String psd) {

    }

}
