package mate.academy.springboot.datajpa.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.springboot.datajpa.model.Product;
import mate.academy.springboot.datajpa.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Not found product with Id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateById(Long id, Product product) {
        Product productById = productRepository.getById(id);
        if (!product.getTitle().isEmpty()) {
            productById.setTitle(product.getTitle());
        }
        if (product.getPrice() != null) {
            productById.setPrice(product.getPrice());
        }
        if (product.getCategory() != null) {
            productById.setCategory(product.getCategory());
        }
        return productRepository.save(productById);
    }

    @Override
    public List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to) {
        return productRepository.findAllByPriceBetween(from, to);
    }

    @Override
    public List<Product> findProductsByCategoriesIds(List<Long> categoriesIds) {
        return productRepository.findProductsByCategoriesIds(categoriesIds);
    }

}
