package br.com.kitplus.service;

import br.com.kitplus.models.Clients.ClientResponseDTO;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public interface ClientService {

    ClientResponseDTO getCustomerClient(String email) throws MPException, MPApiException;
}
