package com.Controller;

import com.Mapper.UserMapper;
import com.Service.UserService;
import com.User.User;
import com.Utils.ResultMsg;
import com.Utils.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    ResultMsg getByaccount(@PathVariable String account){
        return ResultMsg.ok(ResultStatusEnum.SUCCESS, userService.getByAccount(account));

    }
    @PutMapping("/register")
    ResultMsg Register(User user){
        try {
            String action = userService.Register(user);
           if (action=="1")//注册成功
           {
               return ResultMsg.ok(ResultStatusEnum.register_SUCCESS,"注册成功");
           }

            if (action=="0")//密码不符合规则
            {
                return ResultMsg.ok(ResultStatusEnum.ERROR,"密码需要英文和数字且不少于6位");
            }

            return ResultMsg.ok(ResultStatusEnum.ERROR,"账号已存在");






        } catch (Exception e) {
            return ResultMsg.error(ResultStatusEnum.ERROR, String.valueOf(e));
        }
    }
    @GetMapping("/login")
    ResultMsg Login(User user){
        try {
            Integer aciton = userService.login(user);
            if (aciton==1){
                return ResultMsg.ok(ResultStatusEnum.Login_SUCCESS,user.getId());//登陆成功返回Token
            }

            if (aciton==0){
                return ResultMsg.ok(ResultStatusEnum.Login_ERROR,null);//登陆失败,返回空
            }

            return ResultMsg.ok(ResultStatusEnum.SUCCESS,userService.login(user));


        } catch (Exception e) {
         return ResultMsg.error(ResultStatusEnum.ERROR,"0");
        }
    }


}
