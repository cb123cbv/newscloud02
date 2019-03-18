package com.jk.mapper;

import com.jk.bean.Common;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface MeiRiJingXuanMapper {

 List<Common> getYuLe2();

 List<Common> gettiyu2();

 List<Common> getcaijing2();

 List<Common> getjunshi2();
}
