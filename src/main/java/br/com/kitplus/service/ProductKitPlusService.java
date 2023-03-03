package br.com.kitplus.service;

import br.com.kitplus.repository.model.ProductDTO;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;

import java.util.List;

public interface ProductKitPlusService {
    void createProduct(ProductDTO productDTO);

    ProductEntity getProductById(String idProduct);

    ProductEntity editProduct(ProductEntity productEntity);

    void createCategory(ProductCategoriesEntity category);

    void removeCategory(String idCategory);

    void removeAllProducts();

    List<ProductEntity> getAllProducts();

    List<ProductCategoriesEntity> getAllCategories();


}
