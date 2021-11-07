package homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Product createOrderFromProduct(Long productId) {
        System.out.println(productService.getTitleById(productId));
        return productService.getTitleById(productId);
    }
}
