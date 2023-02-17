package br.com.kitplus.service;

import br.com.kitplus.repository.model.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientKitplusService {
   void registerClientKitPlus(Client client) throws Exception;

}
