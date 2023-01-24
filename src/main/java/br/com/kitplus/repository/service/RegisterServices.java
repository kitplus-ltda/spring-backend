package br.com.kitplus.repository.service;

import br.com.kitplus.repository.model.ClientRegister;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service("RegisterServices")
@Configurable
public interface RegisterServices {
     ClientRegister getClientDetails(Integer userId) throws Exception;
     ClientRegister postCreateUser(ClientRegister clientRegister) throws Exception;
}
