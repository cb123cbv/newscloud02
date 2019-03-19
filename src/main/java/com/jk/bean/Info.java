package com.jk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/3/7
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    private String  id;
    private String titleId;
    private String  info;
    private String  tableName;
}
