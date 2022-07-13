package mate.academy.springboot.datajpa.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.springboot.datajpa.model.Product;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    void deleteById(Long id);

    Product update(Product product);

    List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to);

    List<Product> findProductsByCategoriesIds(List<Long> categoriesIds);
}
