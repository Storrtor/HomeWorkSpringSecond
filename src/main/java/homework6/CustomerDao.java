package homework6;

import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getCustomers();

}
