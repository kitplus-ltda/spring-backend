package br.com.kitplus.models.Cards;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.MPHttpClient;
import com.mercadopago.net.MPRequest;
import com.mercadopago.net.MPResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class CardTokenRequest  {
    @ApiModelProperty(value = "Código do Cartão")
    private  String cardId;
    @ApiModelProperty(value = "Código do Consumidor")
    private  String customerId;
    @ApiModelProperty(value = "Código de Segurança")
    private  String securityCode;

}
