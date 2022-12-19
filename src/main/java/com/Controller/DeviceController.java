package com.Controller;

import com.Mapper.DeviceMapper;
import com.Service.DeviceService;
import com.Service.ManageUserServicer;
import com.Utils.ResultMsg;
import com.Utils.ResultStatusEnum;
import com.config.JwtUtil;
import com.entiy.Device;
import com.entiy.DeviceWITHadmin;
import com.entiy.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(tags = "设备控制")
@RestController
@Slf4j
@RequestMapping(value = "admin/device", produces = "application/json;charset=utf-8")
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    @Autowired
    ManageUserServicer manageUserServicer;
    @Value("${Device.purchaseAmount}")
    private int PurchaseAmount;

    @ApiImplicitParam(name = "token", required = false, paramType = "header", dataType = "String")

    @ApiOperation(value = "创建设备")
    @PostMapping("/creatdevice")
    ResultMsg CreatDevice(HttpServletRequest request, Device device) {
        String token = request.getHeader("token");
        //从token解析出id
        String userId = JwtUtil.getUserId(token);
        System.out.println(userId);

        device.setCreateUser(userId);
        //参数合规性校验  name和type不能为空
        if (device.getName() == null && device.getType() == null) {
            log.info(" name和type不能为空");
            return ResultMsg.error(ResultStatusEnum.PARAMS_ERROR);

        }
        //参数合规性校验  保证id唯一，保证name唯一 type为指定值
        Long count = deviceService.CountByid(device.getId(), device.getName());
        if (count != 0 || (device.getType() != 1 && device.getType() != 2 && device.getType() != 3)) {
            System.out.println(count);
            log.info(" 参数不合规");
            return ResultMsg.error(ResultStatusEnum.PARAMS_ERROR);
        }
        //设置售价默认值
        if (device.getPurchaseAmount() == null) {
            device.setPurchaseAmount(PurchaseAmount);
        }


        Integer res = 0;
        try {
            res = deviceService.CreatDevice(device);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.valueOf(e));
            return ResultMsg.error(ResultStatusEnum.ERROR);
        }
        if (res == 0) {
            return ResultMsg.error(ResultStatusEnum.ERROR, "没有找到目标");
        }
        return ResultMsg.ok(ResultStatusEnum.SUCCESS, "成功插入 " + res + " 条结果");
    }
    @ApiImplicitParam(name = "token", required = false, paramType = "header", dataType = "String")

    @ApiOperation(value = "更新设备")
    @PostMapping("/updatedevice")
    ResultMsg UpdateDevice(Device device) {
        //参数合规性校验  name和type不能为空
        if (device.getName() == null && device.getType() == null) {
            return ResultMsg.error(ResultStatusEnum.PARAMS_ERROR);
        }

        //返回操作结果
        Integer res = 0;
        try {
            res = deviceService.UpdateDevice(device);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.valueOf(e));
            return ResultMsg.error(ResultStatusEnum.ERROR);
        }
        if (res == 0) {
            return ResultMsg.error(ResultStatusEnum.ERROR, "没有找到目标");
        }
        return ResultMsg.ok(ResultStatusEnum.SUCCESS, "成功修改 " + res + " 条结果");

    }
    @ApiImplicitParam(name = "token", required = false, paramType = "header", dataType = "String")

    @ApiOperation(value = "根据id查找")
    @GetMapping("/selectdevice")
    ResultMsg SelectDevice(String id) {

        try {
            Device device = deviceService.SelectByid(id);
            return ResultMsg.ok(ResultStatusEnum.SUCCESS, device);
        } catch (Exception e) {
            log.info(String.valueOf(e));
            e.printStackTrace();
            return ResultMsg.error(ResultStatusEnum.ERROR);
        }

    }
    @ApiImplicitParam(name = "token", required = false, paramType = "header", dataType = "String")
    @ApiOperation(value = "根据id删除")
    @DeleteMapping("/deletedevice")
    ResultMsg DeleteDevice(String id) {

        Integer res = 0;
        try {
            res = deviceService.DeleteByid(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.valueOf(e));
            return ResultMsg.error(ResultStatusEnum.ERROR);
        }
        if (res == 0) {
            return ResultMsg.error(ResultStatusEnum.ERROR, "没有找到目标");
        }

        return ResultMsg.ok(ResultStatusEnum.SUCCESS, "成功删除 " + res + " 条结果");

    }

    @ApiImplicitParam(name = "token", required = false, paramType = "header", dataType = "String")

    @ApiOperation(value = "根据管理员id查找设备")
    @GetMapping("/findDevicebyadmin")
    ResultMsg FindDeviceByAdmin(String id) {


        List<DeviceWITHadmin> res = manageUserServicer.selectdevicebyadminid(id);


        return ResultMsg.ok(ResultStatusEnum.SUCCESS, res);

    }

}
