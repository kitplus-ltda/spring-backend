package br.com.kitplus.service;

import br.com.kitplus.models.Clients.ClientResponseDTO;
import br.com.kitplus.models.Clients.CustomerRequestMP;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.customer.Customer;


public interface ClientService {

    ClientResponseDTO getCustomerClient(String email) throws MPException, MPApiException;

    Customer getCustomerById(String id ) throws  MPException, MPApiException;

    Customer updateClientInfo(String id, CustomerRequestMP customer ) throws  MPException, MPApiException;

    Customer createClient(CustomerRequestMP customer) throws MPException, MPApiException;

}
