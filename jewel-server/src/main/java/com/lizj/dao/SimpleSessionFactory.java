package com.lizj.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lizj on 2017/11/11.
 */
public class SimpleSessionFactory {

    private static SqlSession sqlSession;

    public static SqlSession getSqlSession(){
        try {
//            if (sqlSession != null) {
//                return sqlSession;
//            }
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = SqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;

    }
}
