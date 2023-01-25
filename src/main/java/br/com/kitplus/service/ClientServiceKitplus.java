package br.com.kitplus.service;

import br.com.kitplus.repository.model.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientServiceKitplus {
   String  registerClientKitPlus(Client client) throws Exception;

}
