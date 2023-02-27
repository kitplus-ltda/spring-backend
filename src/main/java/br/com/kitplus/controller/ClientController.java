package br.com.kitplus.controller;

import br.com.kitplus.Api.ClientsApi;
import br.com.kitplus.models.Clients.ClientResponseDTO;
import br.com.kitplus.models.Clients.CustomerRequestMP;
import br.com.kitplus.service.CardsService;
import br.com.kitplus.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.client.cardtoken.CardTokenRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.CardToken;
import com.mercadopago.resources.customer.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@Controller
@Api(value = "API Rest Kitplus")
@Service

public class ClientController implements ClientsApi {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CardsService cardsService;

    @GetMapping("/client")
    public ResponseEntity<ClientResponseDTO> getClientbyEmailMP(@RequestParam String email)
            throws MPException, MPApiException {
        ClientResponseDTO clientResponseDTO = clientService.getCustomerClient(email);
        if (clientResponseDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/client_by_id")
    public ResponseEntity<Customer> getClientByiD(@RequestParam String id) throws MPException, MPApiException {
        Customer clientCustomer = clientService.getCustomerById(id);
        if (clientCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientCustomer, HttpStatus.OK);
    }

    @PutMapping("/update_client")
    public ResponseEntity<Customer> putClientInfo(
            @RequestParam String id,
            @RequestBody Object customer)
            throws MPException, MPApiException {

        ObjectMapper mapper = new ObjectMapper();
        CustomerRequestMP customerReq = mapper.convertValue(customer,
                CustomerRequestMP.class);
        Customer customerInfo = clientService.updateClientInfo(id, customerReq);
        if (customerInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerInfo, HttpStatus.OK);
    }

    @PostMapping("/create_customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody(required = false) Object customer)
            throws MPException, MPApiException {

        ObjectMapper mapper = new ObjectMapper();
        CustomerRequestMP customerReq = mapper.convertValue(customer,
                CustomerRequestMP.class);

        Customer customerResponse = clientService.createClient(customerReq);
        if (customerResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PostMapping("/create_card")
    @ApiOperation(value = "Post Credit Card")
    public ResponseEntity<CardToken> createCard(@RequestBody CardTokenRequest card)
            throws MPException, MPApiException, IOException {
        CardTokenRequest request = CardTokenRequest.builder()
                .cardId(card.getCardId())
                .customerId(card.getCustomerId())
                .securityCode(card.getSecurityCode())
                .build();

        return ResponseEntity.ok(cardsService.createCard(request));
    }

    @GetMapping("/health")
    public ResponseEntity<String> heathCheck() {
        return new ResponseEntity<>("Everything is good!!", HttpStatus.OK);
    }

}
