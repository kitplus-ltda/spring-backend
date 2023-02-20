package br.com.kitplus.service.impl;

import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.ErrorService;
import br.com.kitplus.repository.service.RegisterService;
import br.com.kitplus.repository.service.ValidateService;
import br.com.kitplus.service.ClientKitplusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ClientKTServiceImpl implements ClientKitplusService {

    @Autowired
    RegisterService registerServiceDAO;
    @Autowired
    ValidateService validateService;

    @Autowired
    private ErrorService errorService;


    @Override
    @Transactional
    public String registerClientKitPlus(Client client) throws Exception {
        this.validateService.parametrizeClient(client);
        this.registerServiceDAO.validateRegister(client);
        return "CREATED";

    }
}
