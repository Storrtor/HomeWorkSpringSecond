package homework6.repository.customer;

import homework6.model.Customer;
import homework6.model.Order;
import homework6.model.Product;
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
    public void addNewCustomer(String name) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(new Customer(name));
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Customer> getCustomers() {
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

    @Override
    public void doOrder(Long customerId, Long productId) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            Product product = session.get(Product.class, productId);
            session.saveOrUpdate(new Order(customer, product, product.getCost()));
            session.getTransaction().commit();
        }
    }
}
