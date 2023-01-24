package br.com.kitplus.controller;

import br.com.kitplus.Api.ClientsApi;
import br.com.kitplus.models.Clients.ClientResponseDTO;
import br.com.kitplus.service.CardsService;
import br.com.kitplus.service.ClientService;
import com.mercadopago.client.cardtoken.CardTokenRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.CardToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@Api(value = "API Rest Kitplus")

public class ClientController implements ClientsApi {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CardsService cardsService;

    @GetMapping("/client")
    public ResponseEntity<ClientResponseDTO> getClientbyEmailMP(@RequestParam String email) throws MPException, MPApiException {
        ClientResponseDTO clientResponseDTO = clientService.getCustomerClient(email);
        if (clientResponseDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/create_card")
    @ApiOperation(value = "Post Credit Card")
    public ResponseEntity<CardToken> createCard(@RequestBody CardTokenRequest card) throws MPException, MPApiException, IOException {
        CardTokenRequest request = CardTokenRequest.builder()
                .cardId(card.getCardId())
                .customerId(card.getCustomerId())
                .securityCode(card.getSecurityCode())
                .build();

        return ResponseEntity.ok(cardsService.createCard(request));
    }

}
