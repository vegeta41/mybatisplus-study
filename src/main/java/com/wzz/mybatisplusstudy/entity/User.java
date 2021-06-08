package com.wzz.mybatisplusstudy.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.wzz.mybatisplusstudy.enums.statusenum;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //乐观锁
    @Version
    private Integer version;

    private statusenum status;

    @TableLogic
    private Integer deleted;
}