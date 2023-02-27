package br.com.kitplus.service;

import br.com.kitplus.repository.model.Product;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;

import java.util.List;

public interface ProductKitPlusService {
    void createProduct(Product product);
    void createCategory(ProductCategoriesEntity category);
    void removeCategory(String idCategory);
    void removeAllProducts();
    List<ProductEntity> getAllProducts();
    List<ProductCategoriesEntity> getAllCategories();


}
