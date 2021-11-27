package homework6.repository.customer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {

    public List<Customer> getCustomers();
    public List<Customer> getAllCustomersByProductId(Long productId);

}
