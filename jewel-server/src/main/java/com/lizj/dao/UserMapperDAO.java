package com.lizj.dao;

import com.lizj.bean.Orders;
import com.lizj.bean.User;
import java.util.List;

/**
 * Created by lizj on 2017/11/12.
 */
public interface UserMapperDAO {
    User getUserById(int id);

    List<User> getUsers();

    List<User> getUserOrders(int userId);

    List<Orders> getOrdersUser(int userId);

    int insertUser(User user);

    int batchInsterUser(List<User> users);


    User updateUserById(User user);

    void deleteUserById(int id);
}
