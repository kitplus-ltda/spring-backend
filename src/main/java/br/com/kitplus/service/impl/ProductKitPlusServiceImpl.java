package br.com.kitplus.service.impl;

import br.com.kitplus.repository.model.ProductDTO;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import br.com.kitplus.repository.model.ProductEntityConverterDTO;
import br.com.kitplus.repository.service.RegisterService;
import br.com.kitplus.service.ProductKitPlusService;
import br.com.kitplus.service.ValidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class ProductKitPlusServiceImpl implements ProductKitPlusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductKitPlusServiceImpl.class);

    @Autowired
    RegisterService registerServiceDAO;

    @Autowired
    ProductEntityConverterDTO converter;

    @Autowired
    ValidateService validateService;


    @Override
    @Transactional
    public void createProduct(ProductDTO productDTO) {
        LOGGER.info("Registrando produto -- {}", productDTO.getNome());
        validateService.validateProduct(productDTO);
        registerServiceDAO.createProduct(converter.getProductEntity(productDTO));
    }

    @Override
    public ProductEntity getProductById(String id) {
        ProductEntity product = registerServiceDAO.getProductById(id);
        if (!Objects.equals(product, null)) {
            return product;
        } else {
            throw new RuntimeException("GRL-0001");
        }
    }

    @Override
    @Transactional
    public ProductEntity editProduct(ProductEntity productEntity) {
        validateService.validateProduct(productEntity);
        return this.registerServiceDAO.editProductEntity(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return registerServiceDAO.getAllProducts();
    }

    @Override
    public List<ProductCategoriesEntity> getAllCategories() {
        return registerServiceDAO.getAllProductCategories();
    }

    @Override
    public void createCategory(ProductCategoriesEntity category) {
        registerServiceDAO.createProductCategoty(category);
    }

    @Override
    public void removeCategory(String idCategory) {
        registerServiceDAO.removeProductCategory(idCategory);
    }

    @Override
    public void removeAllProducts() {
        registerServiceDAO.removeAllProducts();
    }
}
