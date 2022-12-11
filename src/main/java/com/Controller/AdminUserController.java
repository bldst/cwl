package com.Controller;

import com.Service.AdminUserService;
import com.Utils.Permissions;
import com.Utils.ResultMsg;
import com.Utils.ResultStatusEnum;
import com.entiy.AdminUser;
import com.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/admin", produces = "application/json;charset=utf-8")
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;
    @PostMapping("/login")
    ResultMsg Login(AdminUser adminUser) {
        try {
            Map aciton = adminUserService.login(adminUser);//如果token校验不通过，返回值为空，触发异常


            return ResultMsg.ok(ResultStatusEnum.Login_SUCCESS, aciton);//登陆成功返回Token


        } catch (Exception e) {
            return ResultMsg.error(ResultStatusEnum.Login_ERROR, "请检查账号密码");
        }
    }


//    修改指定id账户的信息
    @PostMapping("/change/byid")
    @Permissions(role = "admin")
    ResultMsg ChangeUserData(HttpServletRequest request, User user ){
        try {
            String token = request.getHeader("token");
            System.out.println(token);
            String res = adminUserService.updateUserByid(user);

            if (Objects.equals(res, "0"))
                return ResultMsg.error(ResultStatusEnum.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error(ResultStatusEnum.ERROR);
        }
        return ResultMsg.ok(ResultStatusEnum.UPDATE_SUCCESS);
    }

}
