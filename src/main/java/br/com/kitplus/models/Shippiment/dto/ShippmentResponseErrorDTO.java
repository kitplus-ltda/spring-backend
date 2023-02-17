package br.com.kitplus.models.Shippiment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShippmentResponseErrorDTO {
    private String codigo;
    private String mensagem;
}
