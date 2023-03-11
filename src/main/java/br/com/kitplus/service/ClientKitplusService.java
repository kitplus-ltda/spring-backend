package br.com.kitplus.service;

import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.entity.ClientEntity;
import com.mercadopago.exceptions.MPApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientKitplusService {
   void registerClientKitPlus(ClientEntity clientEntity) throws Exception;

   void searchCreateUserMP(ClientEntity clientEntity) throws MPApiException;

   void updateClient(ClientEntity clientEntity );
   List<ResumeOrderDTO> getOrderByUser(String userId);

}
