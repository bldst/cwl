package com.entiy;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("User")
public class User implements Serializable {
    private Integer id;
    private String account;
    private String psd;
    private String token;

}
