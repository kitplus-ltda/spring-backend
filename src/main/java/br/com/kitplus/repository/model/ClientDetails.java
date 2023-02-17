package br.com.kitplus.repository.model;

import br.com.kitplus.repository.entity.UserRegisterEntity;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@Setter
@Getter
@NoArgsConstructor
public class ClientDetails {

    UserRegisterEntity client;

}
