package com.coderzoe.dao;

import com.coderzoe.entity.User;
import com.coderzoe.util.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yhs
 * @date 2020/5/19 22:29
 * @description
 */
public class UserMapperTest {
    @Test
    public void test(){
        //step 1 获得SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //step 2 执行Sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        System.out.println(userList);
        //官方建议每次操作完 都需要关闭SqlSession
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById((long) 1);
        System.out.println(userById);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //增删改需要提交事务
        mapper.insertUser(new User((long)4,"lili","111"));
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.update(new User(4L,"meimei","beautiful"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delete(4);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }

    /**
     * @data: 2020/05/20 21:33
     * @author: yhs
     * @return:
     * @description: Mybatis增加或者更新数据的时候 往往需要一个实体类作为参数 这个实体类的字段名要和Mybatis占位符相同
     *               但我们在实际工作中 可能一个实体类有多个字段 这样构造一个实体类可能耗时麻烦 或者不想实体类的字段名与Mybatis占位符相等
     *               这时候可以使用Map结构 一个Map对应一个实体类 Map中的每个元素对应实体类的一个字段
     *               Map的Key对应Mybatis的占位符 Value对应字段的值 这样就可以自定义字段 想任意截取实体类或重命名字段都可以
     */
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",5);
        map.put("userName","mybatis");
        map.put("userPwd","mybatisNb");
        mapper.insertUser2(map);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }


    /**
     * @data: 2020/05/20 21:52
     * @author: yhs
     * @return:
     * @description: Java代码通过通配符做模糊查询 但是通配符往往在Mybatis中写入通配符
     */
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("yhs");
        System.out.println(userList);
        sqlSession.close();
    }

    /**
     * @data: 2020/05/22 23:49
     * @author: yhs
     * @return:
     * @description: 分页
     */
    @Test
    public void findUserByPage(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",3);
        List<User> userByPage = mapper.findUserByPage(map);
        System.out.println(userByPage);
        MybatisUtil.closeSqlSession();
    }

    /**
     * @data: 2020/05/22 23:56
     * @author: yhs
     * @return:
     * @description: 通过RowBounds实现分页
     *               不建议使用RowBounds 因为他是先查出所有的信息 再截取 与limit不同
     */
    @Test
    public void findUserByRowBounds(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<User> userList = sqlSession.selectList("com.coderzoe.dao.UserMapper.getUserList");
        System.out.println(userList);

        RowBounds rowBounds = new RowBounds(0, 2);
        List<User> objects = sqlSession.selectList("com.coderzoe.dao.UserMapper.getUserList", null, rowBounds);
        System.out.println(objects);
        MybatisUtil.closeSqlSession();
    }

    /**
     * @data: 2020/05/23 18:25
     * @author: yhs
     * @return:
     * @description: 使用注解开发  使用注解开发时，如果有对应了接口的XML文件且已经在配置里注册， 则无需再注册
     *               如果没有接口的XML文件 则需要在配置里注册一个类的mapper<mapper class = ""/>
     *               对于复杂一些的SQL或字段映射 则注解的方式并不合适 还是应该在xml文件中写SQL语句与resultMap映射
     */
    @Test
    public void getUsers(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUsers();
        System.out.println(userList);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void getUserByIdAndName(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User yhs = mapper.getUserByIdAndName(1, "yhs");
        System.out.println(yhs);
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void insertUser3(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(6L,"yhs","12321");
        mapper.insertUser3(user);
        sqlSession.commit();
        //打印出来看看
        getUsers();

        MybatisUtil.closeSqlSession();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(6L,"yhs","32121");
        mapper.updateUser(user);
        sqlSession.commit();
        getUsers();

        MybatisUtil.closeSqlSession();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(6);
        getUsers();

        sqlSession.commit();
        getUsers();

        MybatisUtil.closeSqlSession();
    }

}
