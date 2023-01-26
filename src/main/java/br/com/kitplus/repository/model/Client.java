package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@ApiModel
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Client extends Error {
    public Client(Client clientRegister) {
    }
    ClientDetails clientDetails ;
    ClientAddress clientAddress ;
}
