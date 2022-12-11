package com.entiy;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("User")
public class User {
    private Integer id;
    private String account;
    private String psd;
    private String token;

}
