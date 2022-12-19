package com.entiy;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceWITHadmin implements Serializable  {

    private String deviceId;
    private String name;
    private Integer type;
    private Integer purchaseAmount;
    private String createUser;
    private String updateTime;
    private Integer adminId;

    private String account;
}
