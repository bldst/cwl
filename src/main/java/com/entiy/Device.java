package com.entiy;

import lombok.Data;

import java.io.Serializable;

@Data
public class Device implements Serializable {
    private String id;
    private String name;
    private Integer type;
    private Integer purchaseAmount;
    private String createUser;
    private String updateTime;
    private manageUser manageUser;
}
