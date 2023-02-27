package br.com.kitplus.repository.service;

import br.com.kitplus.repository.entity.ClientEntity;

public interface ValidateService {

    void parametrizeClient(ClientEntity clientEntity);
    void validateParamsClient(ClientEntity clientEntity);
}
