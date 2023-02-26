package br.com.kitplus.service.impl;

import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import br.com.kitplus.repository.service.RegisterService;
import br.com.kitplus.service.ProductKitPlusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductKitPlusServiceImpl implements ProductKitPlusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductKitPlusServiceImpl.class);

    @Autowired
    RegisterService registerServiceDAO;


    @Override
    public void createProduct(ProductEntity product) {
        LOGGER.info("Registrando produto -- {}", product.getNome());
        // TODO VALIDAR PRODUTO E REGISTRAR NA BASE
        registerServiceDAO.registerProduct(product);
    }

    @Override
    public List<ProductCategoriesEntity> getAllCategories() {
        return registerServiceDAO.getAllProductCategories();
    }

    @Override
    public void createCategory(ProductCategoriesEntity category) {
        registerServiceDAO.createProductCategoty(category);

    }
}
