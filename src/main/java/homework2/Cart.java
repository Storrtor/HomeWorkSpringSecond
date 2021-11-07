package homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private OrderService orderService;
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private List<Product> productList;

    public Cart(List<Product> productList) {
        this.productList = productList;
    }

    public void addProductById(long id) {
        productList.add(orderService.createOrderFromProduct(id));
    }

    public void removeProductById(long id) {
        productList.remove(orderService.createOrderFromProduct(id));
    }

    @Override
    public String toString() {
        return "productList = " + productList;
    }
}
