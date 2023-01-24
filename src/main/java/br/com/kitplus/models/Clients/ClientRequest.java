package br.com.kitplus.models.Clients;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {

    @ApiModelProperty(value = "Email")
    private String email;
}
