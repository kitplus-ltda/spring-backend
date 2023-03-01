package br.com.kitplus.service.impl;

import br.com.kitplus.repository.entity.ProductImagesEntity;
import br.com.kitplus.repository.model.Product;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import br.com.kitplus.repository.service.RegisterService;
import br.com.kitplus.service.ProductKitPlusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class ProductKitPlusServiceImpl implements ProductKitPlusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductKitPlusServiceImpl.class);

    @Autowired
    RegisterService registerServiceDAO;


    @Override
    @Transactional
    public void createProduct(Product product) {
        LOGGER.info("Registrando produto -- {}", product.getNome());
        ProductCategoriesEntity productCategories = new ProductCategoriesEntity();
        productCategories.setCategory_id(product.getCategory_id());


        ProductEntity productEntity = new ProductEntity();

        productEntity.setAltura(product.getAltura());
        productEntity.setCaracteristicas(product.getCaracteristicas());
        productEntity.setComprimento(product.getComprimento());
        productEntity.setDescricao(product.getDescricao());
        productEntity.setDetalhes(product.getDetalhes());
        productEntity.setLargura(product.getLargura());
        productEntity.setNome(product.getNome());
        productEntity.setPeso(product.getPeso());
        productEntity.setPreco(product.getPreco());
        productEntity.setPromocional(product.getPromocional());
        productEntity.setQuantidade(product.getQuantidade());

        productEntity.setCategory(productCategories);

        List<ProductImagesEntity> productImages = new ArrayList<>();

        for (int i = 0 ; i < product.getProductImages().size(); i++) {
            ProductImagesEntity imagesEntity = new ProductImagesEntity();
            imagesEntity.setImage(product.getProductImages().get(i).getUrl());
            productImages.add(imagesEntity);

        }

        productEntity.setProductImages(productImages);

        registerServiceDAO.createProduct(productEntity);
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
