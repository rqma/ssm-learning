package com.rqma.mybatis.c_mapper.mapper;

import com.rqma.mybatis.c_mapper.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;

public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    //注解Before是在执行本类所有测试方法之前先调用这个方法
    @Before
    public void setup() throws Exception{
        //创建SqlSessionFactory
        String resource="SqlMapConfig.xml";

        //将配置文件加载成流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void findUserById() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //创建UserMapper代理对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //调用userMapper的方法
        User user=userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserByName() {
    }
}