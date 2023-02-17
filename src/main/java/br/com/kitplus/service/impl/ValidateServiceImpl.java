package br.com.kitplus.service.impl;

import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.ValidateService;
import org.springframework.stereotype.Service;

@Service
public class ValidateServiceImpl implements ValidateService {
    @Override
    public void parametrizeClient(Client client) {
        client.getClientAddress().setUser_id_pk(client.getClientDetails());
        client.getUserSign().setUser_id_pk(client.getClientDetails());
    }
}
