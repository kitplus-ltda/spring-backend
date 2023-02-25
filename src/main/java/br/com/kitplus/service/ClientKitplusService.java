package br.com.kitplus.service;

import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.model.Client;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.resources.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientKitplusService {
   void registerClientKitPlus(Client client) throws Exception;

   Customer searchCreateUserMP(Client client) throws MPApiException;

   String updateClient(Client client , String id);
   List<ResumeOrderDTO> getOrderByUser(String userId);

}
