package homework6.services;

import homework6.repository.customer.Customer;
import homework6.repository.customer.CustomerDao;
import homework6.utils.SessionFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> findCustomerByProductId(Long productId) {
        return customerDao.getCustomers();
    }
}
