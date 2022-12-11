package com.entiy;

import lombok.Data;

@Data
public class AdminUser {
    Integer id;
    String account;
    String psd;
    String token;
    String Lastlogintime;
}
