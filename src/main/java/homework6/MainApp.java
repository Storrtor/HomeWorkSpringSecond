package homework6;

import homework6.repository.customer.CustomerDao;
import homework6.repository.customer.CustomerDaoImpl;
import homework6.repository.order.OrderDao;
import homework6.repository.order.OrderDaoImpl;
import homework6.repository.product.ProductDao;
import homework6.repository.product.ProductDaoImp;
import homework6.utils.SessionFactoryUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("homework6");
        SessionFactoryUtils sessionFactoryUtils = context.getBean(SessionFactoryUtils.class);
        CustomerDao customerDao = context.getBean(CustomerDaoImpl.class);
        OrderDao orderDao = context.getBean(OrderDaoImpl.class);
        ProductDao productDao = context.getBean(ProductDaoImp.class);

        System.out.println("---------------");
//        customerDao.getAllCustomersByProductId(2L);
//        productDao.getProductsByCustomerId(1L);

        customerDao.getCustomers();
        System.out.println("----");
        orderDao.getOrders();
        System.out.println("---");
        productDao.getAllProducts();

    }


}
