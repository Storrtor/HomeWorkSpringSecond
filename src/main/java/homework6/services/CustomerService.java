package homework6.services;

import homework6.model.Customer;
import homework6.repository.customer.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void addNewCustomer(String name) {
        customerDao.addNewCustomer(name);
    }

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    public List<Customer> getAllCustomerByProductId(Long productId) {
        return customerDao.getAllCustomersByProductId(productId);
    }

    public void doOrder(Long customerId, Long productId) {
        customerDao.doOrder(customerId, productId);
    }

}
