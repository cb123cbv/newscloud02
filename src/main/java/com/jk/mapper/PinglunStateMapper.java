package com.jk.mapper;

import com.jk.bean.PingLun_State;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PinglunStateMapper {


    @Select("select count(id) from t_pinglun_state s where s.vipid=#{id} ")
    Integer pingLunCount(Integer id);


    List<PingLun_State> querypingLunList(Integer id);

    PingLun_State queryTitleList(PingLun_State pingLun_state);

    void deletes(String substring);

    @Select("select * from t_pinglun_state s where s.vipid=#{id} and pluserid=0 ")
    List<PingLun_State> querySystemInfo(Integer id);
}
