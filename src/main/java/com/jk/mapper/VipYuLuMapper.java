package com.jk.mapper;

import com.jk.bean.Vip;
import com.jk.bean.VipYuLu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface VipYuLuMapper {

 List<VipYuLu> getVipYuLu();

 List<Vip> meizhourenqi();
}
