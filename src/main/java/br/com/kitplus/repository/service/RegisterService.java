package br.com.kitplus.repository.service;

import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.Client;
import br.com.kitplus.repository.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.List;



@Configurable
public interface RegisterService {
     Client getClientDetails(Integer userId) throws Exception;
     void registerClient(Client client) throws Exception;
     void updateClientId(String idMP, Client client);
     List<ResumeOrderDTO> getOrderById(String userId);
     void createProduct(ProductEntity product);
     List<ProductEntity> getAllProducts();
     List<ProductCategoriesEntity> getAllProductCategories();
     void createProductCategoty(ProductCategoriesEntity category);
     void removeProductCategory(String idCategory);
}
