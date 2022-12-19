package com.Controller;

import com.Service.ManageUserServicer;
import com.Utils.ResultMsg;
import com.Utils.ResultStatusEnum;
import com.entiy.User;
import com.entiy.manageUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Api(tags = "管理员登陆注销")
@RestController
@Slf4j
@RequestMapping(value = "admin", produces = "application/json;charset=utf-8")
public class ManagerUserController {
    @Autowired
    ManageUserServicer manageUserServicer;

    @ApiOperation(value = "登陆")
    @GetMapping("/login")
    ResultMsg Login(manageUser user) {
        try {
            Map res_user = manageUserServicer.login(user);
            return ResultMsg.ok(ResultStatusEnum.SUCCESS, res_user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error(ResultStatusEnum.Login_ERROR);
        }

    }
    @ApiImplicitParam(name = "token", required = false, paramType = "header", dataType = "String")
    @ApiOperation(value = "注销")
    @GetMapping("/logout")
    ResultMsg Logout(HttpServletRequest request) {
        try {
            String token = request.getHeader("token");
            if (manageUserServicer.logout(token))
                return ResultMsg.ok(ResultStatusEnum.LOGOUT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error(ResultStatusEnum.LOGOUT_ERROR);
        }
        return null;
    }
}
