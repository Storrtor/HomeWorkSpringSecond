package homework6.services;

import homework6.repository.customer.Customer;
import homework6.repository.product.Product;
import homework6.repository.product.ProductDao;
import homework6.repository.product.ProductDaoImp;
import homework6.utils.SessionFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findProductsByCustomerId(Long customerId) {
        return productDao.getProductsByCustomerId(customerId);
    }


}
