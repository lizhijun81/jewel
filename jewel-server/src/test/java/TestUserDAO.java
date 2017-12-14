import com.lizj.bean.User;
import com.lizj.dao.SimpleSessionFactory;
import com.lizj.dao.UserDAO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by lizj on 2017/11/11.
 */


public class TestUserDAO {

    private UserDAO userDAO;

    @Before
    public void init(){
        userDAO = new UserDAO();
    }


    @Test
    public void testGetUserById(){
        User user = userDAO.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetUsers(){
        List<User> users = userDAO.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("yy");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("beijing");

        User insertUser = userDAO.insertUser(user);
        System.out.println(insertUser);
    }

    @Test
    public void testUpdateUserById() {
        User user = new User();
        user.setId(100);
        user.setUsername("yyyy");
        user.setBirthday(new Date());
        user.setSex("0");
        user.setAddress("beijingchangpeng");

        userDAO.updateUserById(user);
        System.out.println(user);
    }

    @Test
    public void testDeleteUserById() {
        userDAO.deleteUserById(29);
    }

}
