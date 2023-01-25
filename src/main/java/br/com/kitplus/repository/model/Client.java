package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class Client {

    String email;
    String firstName;
    String lastName;
    String defaultCard;
    String dateRegistred;
    String description;
    ClientPhone clientPhone ;
    ClientIdentification clientIdentification ;
    ClientAddress clientAddress;

}
