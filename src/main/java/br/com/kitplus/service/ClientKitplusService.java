package br.com.kitplus.service;

import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.entity.ClientEntity;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.resources.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientKitplusService {
   void registerClientKitPlus(ClientEntity clientEntity) throws Exception;

   Customer searchCreateUserMP(ClientEntity clientEntity) throws MPApiException;

   String updateClient(ClientEntity clientEntity, String id);
   List<ResumeOrderDTO> getOrderByUser(String userId);

}
