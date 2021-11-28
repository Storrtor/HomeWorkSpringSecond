package homework6.repository.customer;

import homework6.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {

    public List<Customer> getCustomers();
    public List<Customer> getAllCustomersByProductId(Long productId);
    public void doOrder(Long customerId ,Long productId);
    public void addNewCustomer(String name);

}
