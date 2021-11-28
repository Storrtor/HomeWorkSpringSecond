package homework6.services;

import homework6.model.Product;
import homework6.repository.product.ProductDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findProductsByCustomerId(Long customerId) {
        return productDao.getProductsByCustomerId(customerId);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public void changeCostOfProduct(Long productId, Integer newCost){
        productDao.changeCostOfProduct(productId, newCost);
    }


}
