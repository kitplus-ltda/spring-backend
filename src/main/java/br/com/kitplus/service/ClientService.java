package br.com.kitplus.service;

import br.com.kitplus.models.Clients.ClientResponseDTO;
import br.com.kitplus.models.Clients.CustomerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.customer.Customer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public interface ClientService {

    ClientResponseDTO getCustomerClient(String email) throws MPException, MPApiException;

    Customer getCustomerById(String id ) throws  MPException, MPApiException;

    Customer createClient(CustomerRequest customer) throws MPException, MPApiException;

}
