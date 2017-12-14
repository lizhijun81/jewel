import com.lizj.bean.Orders;
import com.lizj.bean.User;
import com.lizj.dao.SimpleSessionFactory;
import com.lizj.dao.UserDAO;
import com.lizj.dao.UserMapperDAO;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lizj on 2017/11/11.
 */


public class TestUserMapperDAO {

    private SqlSession sqlSession;

    private UserMapperDAO userMapperDAO;

    @Before
    public void init(){
        sqlSession = SimpleSessionFactory.getSqlSession();
        userMapperDAO = sqlSession.getMapper(UserMapperDAO.class);
    }


    @Test
    public void testGetUserById(){
        User user = userMapperDAO.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetUsers(){
        List<User> users = userMapperDAO.getUsers();
        sqlSession.close();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetUserOrders(){
        List<User> userOrders = userMapperDAO.getUserOrders(1);
        for (User userOrder : userOrders) {
            System.out.println(userOrder);
        }
    }

    @Test
    public void testGetOrdersUser(){
        List<Orders> orders = userMapperDAO.getOrdersUser(1);
        for (Orders order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("yy");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("beijing");

        int num = userMapperDAO.insertUser(user);
        sqlSession.commit();
        System.out.println(user);//id封裝到user中
        System.out.println(num);//返回sql映像的行
    }

    @Test
    public void testBatchInsertUser(){
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUsername("yy");
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("beijing_"+i);
            users.add(user);
        }
        userMapperDAO.batchInsterUser(users);
        sqlSession.commit();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUserById() {
        User user = new User();
        user.setId(100);
        user.setUsername("yyyy");
        user.setBirthday(new Date());
        user.setSex("0");
        user.setAddress("beijingchangpeng");

        userMapperDAO.updateUserById(user);
        sqlSession.commit();
        System.out.println(user);
    }

    @Test
    public void testDeleteUserById() {
        userMapperDAO.deleteUserById(29);
        sqlSession.commit();
    }

    @After
    public void destory(){
        sqlSession.close();
    }

}
