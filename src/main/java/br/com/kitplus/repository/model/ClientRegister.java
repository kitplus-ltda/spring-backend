package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class ClientRegister extends Error {
    ClientDetails clientDetails ;
    ClientAddress clientAddress ;
    public ClientRegister(){

    }
    public ClientRegister( ClientRegister clientRegister){
        clientRegister.setClientAddress(null);
        clientRegister.setClientDetails(null);
    }
}
