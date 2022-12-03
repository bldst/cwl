package com.Controller;

import com.Mapper.UserMapper;
import com.Service.UserService;
import com.User.User;
import com.User.joinMatch;
import com.Utils.JwtUtil;
import com.Utils.ResultMsg;
import com.Utils.ResultStatusEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Api(tags = "首页")
@RestController
@CrossOrigin
@RequestMapping(value = "/index", produces = "application/json;charset=utf-8")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @ApiImplicitParam(name = "token", value = "id", required = false, paramType = "header", dataType = "String")

    @ApiOperation(value = "查询id")
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
            Map aciton = userService.login(user);//如果token校验不通过，返回值为空，触发异常


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

    @RequestMapping(value = "/admin/token", method = RequestMethod.GET)
    public void AdminLoginToken(@RequestParam("account") String name, @RequestParam("psd") String psd) {

    }

    @ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header")
    @DeleteMapping("/login/delete")
    @ResponseBody
        //注销用户
    ResultMsg LoginDelete(HttpServletRequest request) {
        String token = request.getHeader("token");

        //从数据库校验
        try {

            boolean Havetoken = userMapper.selectTokenString(token);
            if (!Havetoken)
                return ResultMsg.error(ResultStatusEnum.ERROR, "token不在数据库");
        } catch (Exception e) {
            e.printStackTrace();

        }

        userService.LogoutUser(token);//清除token

        return ResultMsg.ok(ResultStatusEnum.LOGOUT_SUCCESS, null);
    }

    @ApiImplicitParam(paramType = "header", dataType = "String")
    @GetMapping("/getMatch/{school}")
    String getMatch(@PathVariable Integer school) {

        if (school == 1) {
            String data = "{\"success\":true,\"code\":1,\"msg\":\"成功\",\"data\":{\"teacherCompetitionVos\":[{\"id\":1,\"userId\":2,\"title\":\"中国软件杯学校预选赛\",\"content\":\"<p>中国软件杯学校预选赛测试1</p>\",\"startTime\":\"2022-08-31T16:00:00.000+00:00\",\"endTime\":\"2022-12-30T16:00:00.000+00:00\",\"signup\":1,\"target\":\"软件学院全体学生\",\"type\":\"团队赛\",\"createTime\":\"2022-08-17T03:34:59.000+00:00\",\"updateTime\":\"2022-08-19T02:40:28.000+00:00\",\"deleted\":0,\"aimCompetition\":1,\"state\":0,\"checked\":1,\"schoolId\":1,\"teacher\":{\"id\":1,\"userId\":2,\"school\":\"泉州信息工程学院\",\"depart\":\"软件学院\",\"teacherNo\":\"09010\",\"teacherName\":\"吴宗波\",\"createTime\":\"2022-06-07T12:19:38.000+00:00\",\"updateTime\":\"2022-06-07T12:19:41.000+00:00\",\"professional\":\"讲师\"},\"aimCompetitionName\":\"中国软件杯\"},{\"id\":2,\"userId\":2,\"title\":\"互联网+网页设计大赛\",\"content\":\"# 互联网+网页设计大赛\\n- 活动时间\\n2022年11月正式开始\\n\\n- 活动地点\\n初赛：线上\\n决赛：实训楼SB307\\n\\n- 活动内容\\n比赛分为初赛和决赛\\n初赛：寻找队友->寻找项目->撰写商业计划书\\n*通过专业指导老师审评确定决赛名单\\n决赛：网页设计->现场讲解\\n*通过专业指导老师现场提问和打分确定获奖名单\",\"startTime\":\"2022-10-30T16:00:00.000+00:00\",\"endTime\":\"2022-11-14T16:00:00.000+00:00\",\"signup\":1,\"target\":\"全体学生\",\"type\":\"团队赛\",\"createTime\":\"2022-10-31T08:51:02.000+00:00\",\"updateTime\":\"2022-10-31T11:26:11.000+00:00\",\"deleted\":0,\"aimCompetition\":3,\"state\":0,\"checked\":1,\"schoolId\":1,\"teacher\":{\"id\":1,\"userId\":2,\"school\":\"泉州信息工程学院\",\"depart\":\"软件学院\",\"teacherNo\":\"09010\",\"teacherName\":\"吴宗波\",\"createTime\":\"2022-06-07T12:19:38.000+00:00\",\"updateTime\":\"2022-06-07T12:19:41.000+00:00\",\"professional\":\"讲师\"},\"aimCompetitionName\":\"测试竞赛\"}]}}";
            return data;
        }

        return "请求错误,或者token过期";
    }

    //校验id和token的修改密码
    @PutMapping("/updatePsd")
    ResultMsg updatePsd(HttpServletRequest request, User user) {

        try {
            String token = request.getHeader("token");
            user.setToken(token);
            System.out.println(user);
            userService.updatePsd(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(user.getToken());
        }
        return ResultMsg.ok(ResultStatusEnum.SUCCESS);
    }

    @PostMapping("/joinMatch")
    ResultMsg joinMatch(joinMatch joinMatch) {

        try {
            boolean ok = userMapper.joinMatch(joinMatch);
            if (ok) {
                return ResultMsg.ok(ResultStatusEnum.SUCCESS);
            } else {
                return ResultMsg.error(ResultStatusEnum.ERROR, "报名失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultMsg.error(ResultStatusEnum.ERROR);
    }

    @DeleteMapping("/outMatch")
    ResultMsg outMatch(joinMatch outMatch) {

        try {
            boolean ok = userMapper.outMatch(outMatch);
            if (ok) {
                return ResultMsg.ok(ResultStatusEnum.SUCCESS);
            } else {
                return ResultMsg.error(ResultStatusEnum.ERROR, "取消报名失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultMsg.error(ResultStatusEnum.ERROR);
    }
    //获取指定参赛人员的比赛
    @GetMapping("/getMatchid")
    ResultMsg getMatchid(joinMatch joinMatch){

        try {
            List<joinMatch> res=  userMapper.getMatchid(joinMatch);
            return ResultMsg.ok(ResultStatusEnum.SUCCESS,res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error(ResultStatusEnum.ERROR);
        }

    }

}
