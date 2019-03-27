package com.jk.bean;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import lombok.Data;

import java.io.Serializable;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Data
public class Pl implements Serializable {
 Integer pinglunid;
 String plinfo;
 Integer titleid;
 Integer vipid;
 String datetime;
 String tablename;
 Integer authorid;
 String vipname;

}
