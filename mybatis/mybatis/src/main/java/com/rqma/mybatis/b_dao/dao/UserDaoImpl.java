package com.rqma.mybatis.b_dao.dao;

import com.rqma.mybatis.b_dao.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Description:
 * @Auther: RQMA
 * @Date: 2018/10/25 16:21
 */
public class UserDaoImpl implements UserDao {
    // 需要向dao实现类中注入SqlSessionFactory
    // 这里通过构造方法注入
   private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory=sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",id);
        //释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByName(String name) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<User> list_user = sqlSession.selectList("test.findUserByName",name);
        //释放资源
        sqlSession.close();
        return list_user;
    }

    @Override
    public void insertUser(User user) throws Exception {

    }

    @Override
    public void deleteUser(int id) throws Exception {

    }
}
