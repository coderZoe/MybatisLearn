MyBatis学习
# 搭建Mybatis环境
> 1.新建一个空的Maven项目<br>
> 2.创建Pom依赖
 >> 主要依赖:<code>  <dependency>
                          <groupId>org.mybatis</groupId>
                          <artifactId>mybatis</artifactId>
                          <version>3.4.6</version>
                      </dependency> 
   <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.49</version>
        </dependency></code><br>

>3.编写Mybatis核心配置文件<br>
>4.编写Mybatis工具类<br>
>5.写Dao层代码

## 可能犯的错
> 1.配置文件没有注册<br>
> 2.绑定接口错误<br>
> 3.方法名不多<br>
> 4.返回类型不对<br>
> 5.Maven项目中某些目录没配置生成xml文件<br>
> 6.增删改需要提交事务