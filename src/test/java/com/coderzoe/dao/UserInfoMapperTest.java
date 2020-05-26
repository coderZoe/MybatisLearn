package com.coderzoe.dao;

import com.coderzoe.entity.UserInfo;
import com.coderzoe.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yhs
 * @date 2020/5/22 21:16
 * @description
 */
public class UserInfoMapperTest {

    /**
     * @data: 2020/05/22 21:24
     * @author: yhs
     * @return:
     * @description: 这里故意将表和JavaBean设置的字段名设置的不一样 我们可以通过resulMap标签
     * 将数据库字段名与表字段名进行关联映射 然后Mybatis里数据库SQl语句返回的需要是resultMap 不再是resultType
     * 那个字段不一样转哪个字段就好
     * 对于驼峰式与数据库下划线命名方式：
     * <setting name="mapUnderscoreToCamelCase" value="true"/> 这样在配置文里配置即可 不需要再用resultMap映射
     */
    @Test
    public void getUserInfoById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfoById = mapper.getUserInfoById(1);
        System.out.println(userInfoById);
    }

    @Test
    public void getUserList(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> allUserInfo = mapper.getAllUserInfo();
        System.out.println(allUserInfo);
    }
}
