package br.com.kitplus.service.impl;

import br.com.kitplus.models.Clients.*;
import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterService;
import br.com.kitplus.repository.service.ValidateService;
import br.com.kitplus.service.ClientKitplusService;
import br.com.kitplus.service.ClientService;
import br.com.kitplus.service.ProductKitPlusService;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.customer.Customer;
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
}
