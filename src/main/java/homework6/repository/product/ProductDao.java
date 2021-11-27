package homework6.repository.product;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao {

    public List<Product> getAllProducts();
    public List<Product> getProductsByCustomerId(Long customerID);

}
