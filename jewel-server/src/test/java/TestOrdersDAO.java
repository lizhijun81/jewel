import com.lizj.bean.Orders;
import com.lizj.dao.OrdersDAO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lizj on 2017/11/12.
 */
public class TestOrdersDAO {

    private OrdersDAO ordersDAO;

    @Before
    public void init(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        ordersDAO = (OrdersDAO) ac.getBean("ordersDAO");
    }

    @Test
    public void testGetOrdersById(){
        Orders orders = ordersDAO.getOrderById(3);
        System.out.println(orders);
    }

}
