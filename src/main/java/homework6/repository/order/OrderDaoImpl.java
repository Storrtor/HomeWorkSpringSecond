package homework6.repository.order;

import homework6.model.Customer;
import homework6.model.Order;
import homework6.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao{

    private SessionFactoryUtils factoryUtils;

    @Autowired
    public OrderDaoImpl(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    @Override
    public List<Order> getOrders() {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("SELECT o FROM Order o").getResultList();
            System.out.println(orders);
            session.getTransaction().commit();
            return orders;
        }
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            System.out.println(customer.getOrders());
            session.getTransaction().commit();
            return customer.getOrders();
        }
    }
}
