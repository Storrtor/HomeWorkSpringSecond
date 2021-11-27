package homework6.repository.order;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {

    public List<Order> getOrders();

}
