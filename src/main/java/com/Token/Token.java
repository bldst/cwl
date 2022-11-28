package com.Token;

import lombok.Data;

@Data
public class Token {

    /* tokenId */
    private Long id;

    /* 用户ID */
    private Long userId;

    /* 刷新时间 */
    private int buildTime;

    /* token */
    private String token;
}
