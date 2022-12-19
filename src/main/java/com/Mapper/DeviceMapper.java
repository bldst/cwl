package com.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entiy.Device;

public interface DeviceMapper extends BaseMapper<Device> {
    Device selectDevice(String id);

}
