package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class ClientDocuments {
    public ClientDocuments(){};

    String documentType  = null;
    String documentNumber  = null;
}
