package br.com.kitplus.service;

import br.com.kitplus.repository.entity.Product;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;

import java.util.List;

public interface ProductKitPlusService {
    void createProduct(Product product);
    List<ProductEntity> getAllProducts();
    List<ProductCategoriesEntity> getAllCategories();
    void createCategory(ProductCategoriesEntity category);
    void removeCategory(String idCategory);

}
