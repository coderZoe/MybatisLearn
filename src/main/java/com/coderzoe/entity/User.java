package com.coderzoe.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * @author yhs
 * @date 2020/5/19 22:00
 * @description 数据库实体
 */

@Data //无参构造 toString hashcode equals getter setter
@NoArgsConstructor  //无参
@AllArgsConstructor //有参
@EqualsAndHashCode //equals和hashcode方法
@Getter //get方法 放到类上生成所有的get方法 放到字段生成这个字段的get方法
@Setter //set方法 同get
public class User {
    private Long id;
    private String name;
    private String password;

}
