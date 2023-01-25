package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class Client extends Error {
    ClientDetails clientDetails ;
    ClientAddress clientAddress ;
    public Client(){

    }
    public Client(Client clientRegister){
        clientRegister.setClientAddress(null);
        clientRegister.setClientDetails(null);
    }
}
