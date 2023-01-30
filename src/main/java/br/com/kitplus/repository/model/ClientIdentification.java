package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@Setter
@Getter
@NoArgsConstructor
public class ClientIdentification {
    String type = null;
    String number = null;
}
