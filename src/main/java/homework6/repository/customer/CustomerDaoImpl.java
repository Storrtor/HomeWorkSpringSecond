package homework6.repository.customer;

import homework6.repository.order.Order;
import homework6.repository.product.Product;
import homework6.repository.product.ProductDao;
import homework6.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private SessionFactoryUtils factoryUtils;

    @Autowired
    public CustomerDaoImpl(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    @Override
    public List getCustomers() {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers =  session.createQuery("SELECT c FROM Customer c").getResultList();
            System.out.println(customers);
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public List<Customer> getAllCustomersByProductId(Long productId) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            List<Order> orders = product.getOrders();
            List<Customer> customers = new ArrayList<>();
            for (Order o : orders) {
                customers.add(o.getCustomer());
            }
            System.out.println(customers);
            session.getTransaction().commit();
            return customers;
        }
    }
}
