package br.com.kitplus.service;

import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.client.cardtoken.CardTokenClient;
import com.mercadopago.client.cardtoken.CardTokenRequest;
import com.mercadopago.client.customer.CustomerCardCreateRequest;
import com.mercadopago.client.customer.CustomerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.CardToken;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service("CardsService")
@Configurable
public interface CardsService {

    CardToken createCard(CardTokenRequest cardRequest) throws MPException, MPApiException;



}
