package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@Setter
@Getter
@NoArgsConstructor
public class ClientAddress {

    String zipCode = null;
    String street = null;
    String number = null;
    String neighborhood = null;
    String city = null;
    String state = null;
}
