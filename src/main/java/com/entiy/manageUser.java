package com.entiy;

import lombok.Data;

import java.util.List;

@Data
public class manageUser {
    private Integer id;
    private String token;
    private String psd;
    private String account;
    private List<Device> device;
}
