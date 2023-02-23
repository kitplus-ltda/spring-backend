package br.com.kitplus.service.impl;

import br.com.kitplus.models.Clients.*;
import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterService;
import br.com.kitplus.repository.service.ValidateService;
import br.com.kitplus.service.ClientKitplusService;
import br.com.kitplus.service.ClientService;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;


@Service
public class ClientKTServiceImpl implements ClientKitplusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientKTServiceImpl.class);

    @Autowired
    RegisterService registerServiceDAO;
    @Autowired
    ValidateService validateService;
    @Autowired
    ClientService clientServiceMP;

    @Override
    @Transactional
    public void registerClientKitPlus(Client client) throws Exception {
        this.validateService.parametrizeClient(client);
        this.validateService.validateParamsClient(client);
        this.searchMpClient(client);
        this.registerServiceDAO.register(client);
    }

    @Override
    public String updateClient(Client client, String id) {
        this.registerServiceDAO.updateClientId(id, client);
        return id;
    }

    @Override
    public Customer searchCreateUserMP(Client client) throws MPApiException {
        try {
            if (Objects.equals(client.getClientDetails().getIdPaymentIntegration(), null)) {
                //address info
                CustomerAddressRequest addressRequest = new CustomerAddressRequest();
                addressRequest.setStreetName(client.getClientAddress().getStreet());
                addressRequest.setStreetNumber(client.getClientAddress().getNumber());
                addressRequest.setZipCode(client.getClientAddress().getZipcode());
                addressRequest.setId(String.valueOf(client.getClientAddress().getAddress_id()));

                //client info
                CustomerRequestMP customerMP = new CustomerRequestMP();
                customerMP.setFirstName(client.getClientDetails().getName());
                customerMP.setLastName(client.getClientDetails().getLastName());
                customerMP.setEmail(client.getClientDetails().getEmail());

                //identification
                Identification identification = new Identification();
                identification.setNumber(client.getClientDetails().getDocumentNumber());
                identification.setType(client.getClientDetails().getDocumentType());

                //phone
                Phone phone = new Phone();
                phone.setNumber("99999999999");
                phone.setAreaCode("99");

                customerMP.setPhone(phone);
                customerMP.setAddress(addressRequest);
                customerMP.setIdentification(identification);

                Customer customer = clientServiceMP.createClient(customerMP);

                if (!Objects.equals(customer, null)) {
                    return customer;
                } else {
                    throw new RuntimeException("USR-0004");
                }
            }
        } catch (MPException e) {
            LOGGER.error(String.valueOf(e.getCause()));
        } catch (MPApiException e) {
            LOGGER.error(String.valueOf(e.getApiResponse().getContent()));
            throw new MPApiException("Error", e.getApiResponse());
        }
        return null;
    }

    private void searchMpClient(Client client) throws MPException, MPApiException {
        //Busca no MP se cliente já existe e recupera ID
        ClientResponseDTO checkIfClientExistInMP =
                clientServiceMP.getCustomerClient(client.getUserSign().getEmail());
        if (checkIfClientExistInMP.getResults() != null) {
            int size = checkIfClientExistInMP.getResults().size();

            for (int i = 0; i < size; i++) {
                client.getClientDetails().setIdPaymentIntegration(
                        checkIfClientExistInMP.getResults().get(i).getId());
            }
        }
    }
}
