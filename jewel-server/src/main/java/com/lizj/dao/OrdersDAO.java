package com.lizj.dao;

import com.lizj.bean.Orders;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value="orders", key = "#id")
    public Orders getOrderById(int id) {
        System.out.println("============"+id);
        return this.getSqlSession().selectOne("orders.getOrderById", id);
    }
}
