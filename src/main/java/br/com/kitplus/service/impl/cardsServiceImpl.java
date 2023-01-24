package br.com.kitplus.service.impl;

import br.com.kitplus.service.CardsService;
import com.mercadopago.client.cardtoken.CardTokenClient;
import com.mercadopago.client.cardtoken.CardTokenRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.CardToken;
import org.springframework.beans.factory.annotation.Autowired;

public class cardsServiceImpl implements CardsService {

    @Autowired
    private CardTokenClient cardTokenClient;


    public CardToken createCard(CardTokenRequest cardRequest) throws MPException, MPApiException {
         CardToken response =  cardTokenClient.create(cardRequest);
         return response;
    }

}
