package br.com.kitplus.repository.service;

import br.com.kitplus.repository.model.Client;
import org.springframework.beans.factory.annotation.Configurable;



@Configurable
public interface RegisterService {
     Client getClientDetails(Integer userId) throws Exception;
     void register(Client client) throws Exception;
     void updateClientId(String idMP, Client client);
}
