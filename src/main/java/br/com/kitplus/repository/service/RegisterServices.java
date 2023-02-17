package br.com.kitplus.repository.service;

import br.com.kitplus.repository.model.Client;
import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintDeclarationException;

@Configurable
public interface RegisterServices {
     Client getClientDetails(Integer userId) throws Exception;
     void register(Client clientRegister) throws ConstraintDeclarationException;

     boolean validateRegister(Client client);
}
