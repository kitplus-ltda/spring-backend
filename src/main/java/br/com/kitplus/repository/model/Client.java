package br.com.kitplus.repository.model;

import br.com.kitplus.repository.entity.UserAddressEntity;
import br.com.kitplus.repository.entity.UserRegisterEntity;
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

public class Client {
    UserRegisterEntity clientDetails;
    UserAddressEntity clientAddress;
}
