package com.entiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("matchjoin")
public class joinMatch {
    @TableId(type = IdType.AUTO)

    private  Integer id;
    private  String sutdent_id;
    private  String matchid;
}