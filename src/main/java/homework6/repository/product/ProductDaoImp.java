package homework6.repository.product;

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
public class ProductDaoImp implements ProductDao {

    private SessionFactoryUtils factoryUtils;

    @Autowired
    public ProductDaoImp(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    @Override
    public List<Product> getAllProducts() {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
            System.out.println(products);
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Product> getProductsByCustomerId(Long customerId) {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            List<Order> orders = customer.getOrders();
            List<Product> products = new ArrayList<>();
            for (Order o : orders) {
                products.add(o.getProduct());
            }
            System.out.println(products);
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void changeCostOfProduct(Long productId, Integer newCost) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            product.setCost(newCost);
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }


}
