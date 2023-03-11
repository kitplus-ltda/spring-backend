package br.com.kitplus.service.impl;

import br.com.kitplus.models.Clients.*;
import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.entity.ClientEntity;
import br.com.kitplus.repository.service.RegisterService;
import br.com.kitplus.service.ValidateService;
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
import java.util.List;
import java.util.Objects;


@Service
public class ClientKitPlusServiceImpl implements ClientKitplusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientKitPlusServiceImpl.class);

    @Autowired
    RegisterService registerServiceDAO;
    @Autowired
    ValidateService validateService;
    @Autowired
    ClientService clientServiceMP;

    @Override
    @Transactional
    public void registerClientKitPlus(ClientEntity clientEntity) throws Exception {
        this.validateService.parametrizeClient(clientEntity);
        this.validateService.validateParamsClient(clientEntity);
        this.searchMpClient(clientEntity);
        this.registerServiceDAO.registerClient(clientEntity);
        this.searchCreateUserMP(clientEntity);
    }

    @Override
    public void updateClient(ClientEntity clientEntity) {
        this.registerServiceDAO.updateClientId(clientEntity);
    }

    @Override
    public List<ResumeOrderDTO> getOrderByUser(String userId) {
        List<ResumeOrderDTO> orders = registerServiceDAO.getOrderById(userId);
        return orders;
    }

    @Override
    public void searchCreateUserMP(ClientEntity clientEntity) throws MPApiException {
        try {
            if (Objects.equals(clientEntity.getClientDetails().getIdPaymentIntegration(), null)) {
                //address info
                CustomerAddressRequest addressRequest = new CustomerAddressRequest();
                addressRequest.setStreetName(clientEntity.getClientAddress().getStreet());
                addressRequest.setStreetNumber(clientEntity.getClientAddress().getNumber());
                addressRequest.setZipCode(clientEntity.getClientAddress().getZipcode());
                addressRequest.setId(String.valueOf(clientEntity.getClientAddress().getAddress_id()));

                //clientEntity info
                CustomerRequestMP customerMP = new CustomerRequestMP();
                customerMP.setFirstName(clientEntity.getClientDetails().getName());
                customerMP.setLastName(clientEntity.getClientDetails().getLastName());
                customerMP.setEmail(clientEntity.getClientDetails().getEmail());

                //identification
                Identification identification = new Identification();
                identification.setNumber(clientEntity.getClientDetails().getDocumentNumber());
                identification.setType(clientEntity.getClientDetails().getDocumentType());

                //phone
                Phone phone = new Phone();
                phone.setNumber("99999999999");
                phone.setAreaCode("99");

                customerMP.setPhone(phone);
                customerMP.setAddress(addressRequest);
                customerMP.setIdentification(identification);

                Customer customer = clientServiceMP.createClient(customerMP);

                if (!Objects.equals(customer, null)) {
                    clientEntity.getClientDetails().setIdPaymentIntegration(customer.getId());
                    this.updateClient(clientEntity);
                }
            }
        } catch (MPException e) {
            LOGGER.error(String.valueOf(e.getCause()));
        } catch (MPApiException e) {
            LOGGER.error(String.valueOf(e.getApiResponse().getContent()));
            throw new MPApiException("Error", e.getApiResponse());
        }
    }

    private void searchMpClient(ClientEntity clientEntity) {
        //Busca no MP se cliente já existe e recupera ID
        try {
            ClientResponseDTO checkIfClientExistInMP =
                    clientServiceMP.getCustomerClient(clientEntity.getUserSign().getEmail());

            if (!Objects.equals(checkIfClientExistInMP, null)) {
                int size = checkIfClientExistInMP.getResults().size();

                for (int i = 0; i < size; i++) {
                    clientEntity.getClientDetails().setIdPaymentIntegration(
                            checkIfClientExistInMP.getResults().get(i).getId());
                }
            }
        } catch (Exception e) {
            LOGGER.warn("Erro na consulta do cliente");
        }
    }
}
