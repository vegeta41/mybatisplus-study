package com.wzz.mybatisplusstudy.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum statusenum {
    WORK(1,"上班"),
    REST(0,"休息");

    statusenum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @EnumValue
    private Integer code;
    private String msg;
}
