package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegister extends Error {
    ClientDetails clientDetails ;
    ClientAddress clientAddress ;

	public ClientRegister(ClientRegister clientRegister) {
		super();
	}
}
