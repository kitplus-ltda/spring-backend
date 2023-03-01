package br.com.kitplus.repository.service;

import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ClientEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.List;



public interface RegisterService {
     void registerClient(ClientEntity clientEntity) throws Exception;
     void updateClientId(String idMP, ClientEntity clientEntity);
     void createProduct(ProductEntity product);
     void createProductCategoty(ProductCategoriesEntity category);
     void removeProductCategory(String idCategory);
     void removeAllProducts();
     ClientEntity getClientDetails(Integer userId) throws Exception;
     List<ResumeOrderDTO> getOrderById(String userId);
     List<ProductEntity> getAllProducts();
     List<ProductCategoriesEntity> getAllProductCategories();
     ProductEntity getProductById(String id);
     ProductEntity editProductEntity(ProductEntity product);



}
