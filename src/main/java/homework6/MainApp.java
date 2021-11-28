package homework6;

import homework6.repository.customer.CustomerDao;
import homework6.repository.customer.CustomerDaoImpl;
import homework6.repository.order.OrderDao;
import homework6.repository.order.OrderDaoImpl;
import homework6.repository.product.ProductDao;
import homework6.repository.product.ProductDaoImp;
import homework6.services.CustomerService;
import homework6.services.OrderService;
import homework6.services.ProductService;
import homework6.utils.SessionFactoryUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("homework6");
        SessionFactoryUtils sessionFactoryUtils = context.getBean(SessionFactoryUtils.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        OrderService orderService = context.getBean(OrderService.class);
        ProductService productService = context.getBean(ProductService.class);

        try {
            customerService.findCustomerByProductId(1L);
            orderService.getOrders();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactoryUtils.getSession() != null) {
                sessionFactoryUtils.getSession().close();
            }
            sessionFactoryUtils.shutdown();
        }

    }
}
