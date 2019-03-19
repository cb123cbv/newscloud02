package com.jk.bean;

import lombok.Data;

@Data
public class VipState {

    Integer id;
    Integer userid;
    long startTime;
    long endTime;
    Integer NoteState;
    Integer vipState;

    //--------------------充值vip
    Integer yue;//冲了几个月
    Integer money;//充值金额
}
