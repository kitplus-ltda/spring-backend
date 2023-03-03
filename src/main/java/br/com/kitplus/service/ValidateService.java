package br.com.kitplus.service;

import br.com.kitplus.repository.entity.ClientEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import br.com.kitplus.repository.model.ProductDTO;

public interface ValidateService {

    void parametrizeClient(ClientEntity clientEntity);
    void validateParamsClient(ClientEntity clientEntity);
    void validateProduct(ProductEntity dto);
    void validateProduct(ProductDTO dto);
}
