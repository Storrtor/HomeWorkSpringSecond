package homework6;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao{

    private SessionFactoryUtils factoryUtils;

    @Autowired
    public CustomerDaoImpl(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = factoryUtils.getSession();
        session.beginTransaction();
        List<Customer> customers = session.createQuery("SELECT c FROM Customer c").getResultList();
        session.getTransaction().commit();
        return customers;
    }



}
