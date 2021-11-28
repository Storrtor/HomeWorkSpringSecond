package homework6.repository.order;

import homework6.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {

    public List<Order> getOrders();
    public List<Order> getOrdersByCustomerId(Long customerId);

}
