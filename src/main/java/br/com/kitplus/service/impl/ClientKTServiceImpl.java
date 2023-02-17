package br.com.kitplus.service.impl;

import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterServices;
import br.com.kitplus.service.ClientKitplusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ClientKTServiceImpl implements ClientKitplusService {

    @Autowired
    RegisterServices registerServicesDAO;

    @Override
    @Transactional
    public void registerClientKitPlus(Client client) {
        if (registerServicesDAO.validateRegister(client)) {
            registerServicesDAO.register(client);
            //TODO CHAMAR API MERCADO PAGO
        } else {
            throw new IllegalArgumentException("documento e/ou email já cadastrado");
        }
    }
}
