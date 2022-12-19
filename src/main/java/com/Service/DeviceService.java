package com.Service;

import com.entiy.Device;

public interface DeviceService {
    Integer CreatDevice(Device device);
    Integer UpdateDevice(Device device);
    Device SelectByid(String id);
    Integer DeleteByid(String id);
    Long CountByid(String id,String name);
}
