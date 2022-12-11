package com.Controller;

import com.Service.UserService;
import com.Utils.ResultMsg;
import com.Utils.ResultStatusEnum;
import com.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usertoken")
public class UserTokenController {
@Autowired
UserService userService;
@GetMapping("/login")
    ResultMsg login(User user){

    return ResultMsg.ok(ResultStatusEnum.SUCCESS,userService.login(user));
}
//注销，根据传入的token，把token设置为空，使其token校验不通过
    @PostMapping ("/logout")
    ResultMsg logout(@RequestHeader String token){
        try {
            userService.LogoutUser(token);
            return ResultMsg.ok(ResultStatusEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace( );
        }
        return  ResultMsg.error(ResultStatusEnum.ERROR);
    }

}
