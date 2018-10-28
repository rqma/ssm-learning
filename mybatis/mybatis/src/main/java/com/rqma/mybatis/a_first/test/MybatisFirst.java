package com.rqma.mybatis.a_first.test;

import com.rqma.mybatis.a_first.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther: RQMA
 * @Date: 2018/10/21 14:05
 */
public class MybatisFirst {
    @Test
    public void findUserByIdTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() throws IOException {
        SqlSession sqlSession = DBHelper.getSession();
        List<User> list = sqlSession.selectList("test.findUserByName", "明");
        System.out.println(list);
        // 释放资源
        sqlSession.close();
    }

    // 添加用户信息
    @Test
    public void insertUserTest() throws IOException {
        SqlSession sqlSession = DBHelper.getSession();
        // 插入用户对象
        User user = new User();
        user.setUsername("赵云");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("辽宁沈阳");
        sqlSession.insert("test.insertUser", user);
        // 提交事务
        sqlSession.commit();
        System.out.println(user.getId());
        // 关闭会话
        sqlSession.close();
    }

    // 根据id删除 用户信息
    @Test
    public void deleteUserTest() throws IOException {
        SqlSession sqlSession = DBHelper.getSession();

        sqlSession.delete("test.deleteUserById", 27);
        sqlSession.commit();
        sqlSession.close();
    }

    // 根据id更新 用户信息
    @Test
    public void updateUserTest() throws IOException {
        SqlSession sqlSession = DBHelper.getSession();
        User user = new User();
        //必须设置id
        user.setId(26);
        user.setUsername("哈哈");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setAddress("辽宁沈阳");
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
class DBHelper {
    public static SqlSessionFactory sessionFactory;
    static {
        try {
            String resource= "SqlMapConfig.xml";
            Reader reader=Resources.getResourceAsReader(resource);
            sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

}

