package com.Service.impl;

import com.Mapper.DeviceMapper;
import com.Service.DeviceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entiy.Device;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.text.SimpleDateFormat;
import java.util.Date;
@Slf4j
@Service
public class DeviceServiceimpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public Integer CreatDevice(Device device) {
        //获取时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        device.setUpdateTime(time);
        int res;
        try {
            res = deviceMapper.insert(device);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.valueOf(e));
            return 0;
        }

        return res;
    }

    @Override
    public Integer UpdateDevice(Device device) {
        //获取时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        device.setUpdateTime(time);

        int res;
        try {
            res = deviceMapper.updateById(device);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.valueOf(e));
            return 0;
        }

        return res;
    }

    @Override
    public Device SelectByid(String id) {
        try {
            Device device = deviceMapper.selectDevice(id);
            return device;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.valueOf(e));
            return null;
        }
    }

    @Override
    public Integer DeleteByid(String id) {
        int res;
        try {
            res = deviceMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(String.valueOf(e));
            return 0;
        }

        return res;
    }

    @Override
    public Long CountByid(String id,String name) {
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id).or()
                .eq("name",name);
        return   deviceMapper.selectCount(queryWrapper);

    }
}
