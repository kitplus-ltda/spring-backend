package br.com.kitplus.repository.service;

import br.com.kitplus.repository.model.Client;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service("RegisterServices")
@Configurable
public interface RegisterServices {
     Client getClientDetails(Integer userId) throws Exception;
     Client postCreateUser(Client clientRegister) throws Exception;
}
