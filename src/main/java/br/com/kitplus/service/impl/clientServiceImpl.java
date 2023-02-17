package br.com.kitplus.service.impl;

import br.com.kitplus.models.Clients.ClientResponseDTO;
import br.com.kitplus.repository.service.LogsService;
import br.com.kitplus.service.ClientService;
import br.com.kitplus.utils.CustomerUtil;
import br.com.kitplus.utils.IntegrationUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadopago.client.customer.CustomerClient;
import com.mercadopago.client.customer.CustomerRequest;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.customer.Customer;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class clientServiceImpl implements ClientService {
        private static final Logger logger = LoggerFactory.getLogger(clientServiceImpl.class);
        private static final TypeReference<ClientResponseDTO> clientResponse = new TypeReference<>() {
        };

        @Value("${url.mp}")
        private String urlMp;

        @Autowired
        private IntegrationUtil integrationUtil;

        @Autowired
        private LogsService logsService;

        @SneakyThrows
        @Override
        public ClientResponseDTO getCustomerClient(String email) throws MPException, MPApiException {

                logger.info("Calling Client By Email MP");
                // logsService.inrLog(email , "getCustomerClient");

                ResponseEntity<ClientResponseDTO> response = integrationUtil.getRestCall(
                                urlMp + "/v1/customers/search?email=" + email,
                                "GET",
                                null,
                                clientResponse, null);

                if (response.getBody() != null && response.getBody().getResults().size() != 0) {
                        return response.getBody();
                }
                return null;
        }

        @Override
        public Customer getCustomerById(String id) throws MPException, MPApiException {
                logger.info("Calling  Client by id");
                CustomerClient client = new CustomerClient();
                return client.get(id);
        }

        public Customer createClient(br.com.kitplus.models.Clients.CustomerRequest clientRequest)
                        throws MPException, MPApiException {
                logger.info("Calling Create Client");
                CustomerClient client = new CustomerClient();
                CustomerRequest customerRequest = CustomerUtil.createCustomerRequest(clientRequest, "create");
                return client.create(customerRequest);
        }

        @Override
        public Customer updateClientInfo(String id, br.com.kitplus.models.Clients.CustomerRequest clientRequest)
                        throws MPException, MPApiException {
                logger.info("Calling Update Client");
                CustomerClient client = new CustomerClient();
                MPRequestOptions options = MPRequestOptions.builder()
                 .connectionTimeout(10000)
                 .connectionRequestTimeout(10000)
                .build();
                CustomerRequest customerRequest = CustomerUtil.createCustomerRequest(clientRequest, "update");
                return client.update(id, customerRequest, options);
        }

}
