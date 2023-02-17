package br.com.kitplus.models.Cards;


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
