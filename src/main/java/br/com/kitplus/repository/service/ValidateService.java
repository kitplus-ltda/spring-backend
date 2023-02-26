package br.com.kitplus.repository.service;

import br.com.kitplus.repository.entity.Client;

public interface ValidateService {

    void parametrizeClient(Client client);
    void validateParamsClient(Client client);
}
