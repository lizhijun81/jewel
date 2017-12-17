package com.lizj.dao;

import com.lizj.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by lizj on 2017/11/11.
 */
public class UserDAO {

    @Cacheable(value="user", key = "#id")
    public User getUserById(int id){
        SqlSession sqlSession = SimpleSessionFactory.getSqlSession();
        User user = sqlSession.selectOne("user.getUserById", id);
        sqlSession.close();
        return user;
    }

    public List<User> getUsers() {
        SqlSession sqlSession = SimpleSessionFactory.getSqlSession();
        List<User> users = sqlSession.selectList("user.getUsers");
        sqlSession.close();
        return users;
    }

    public User insertUser(User user){
        SqlSession sqlSession = SimpleSessionFactory.getSqlSession();
        sqlSession.insert("user.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    public User updateUserById(User user){
        SqlSession sqlSession = SimpleSessionFactory.getSqlSession();
        sqlSession.update("user.updateUserById", user);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    public void deleteUserById(int id){
        SqlSession sqlSession = SimpleSessionFactory.getSqlSession();
        sqlSession.delete("user.deleteUserById", id);
        sqlSession.commit();
        sqlSession.close();
    }


}
