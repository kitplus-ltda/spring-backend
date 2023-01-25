package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class ClientAddress {

    String id = null;
    String zipCode = null;
    String streetName = null;
    String streetNumber = null;
}
