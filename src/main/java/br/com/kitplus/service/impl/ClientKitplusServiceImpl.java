package br.com.kitplus.service.impl;

import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterServices;
import br.com.kitplus.service.ClientKitplusService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class ClientKitplusServiceImpl implements ClientKitplusService {

    @Autowired
    RegisterServices registerServicesDAO;

    @Override
    @Transactional
    public String registerClientKitPlus(Client client) throws Exception {
        return registerServicesDAO.register(client);
    }
}
