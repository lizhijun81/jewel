package com.lizj.dao;

import com.lizj.bean.Orders;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * Created by lizj on 2017/11/12.
 */
@Component
public class OrdersDAO extends SqlSessionDaoSupport {

    @Override
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public Orders getOrderById(int id) {
        return this.getSqlSession().selectOne("orders.getOrderById", id);
    }
}
