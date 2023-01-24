package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@ApiModel
@Setter
@Getter
public class ClientDetails {

    public ClientDetails( ){
    };

    Integer id = null;
    String name  = null;
    String lastName  = null;
    Date birthDate  = null;
    String email  = null;
    String user  = null;
    String password = null;
    ClientDocuments clientDocuments = null;


}
