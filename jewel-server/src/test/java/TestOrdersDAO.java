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
        ordersDAO.getOrderById(3);
        ordersDAO.getOrderById(4);
        ordersDAO.getOrderById(5);
    }

}
