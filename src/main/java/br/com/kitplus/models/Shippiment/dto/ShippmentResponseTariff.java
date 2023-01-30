package br.com.kitplus.models.Shippiment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippmentResponseTariff {
        private Number  valor;
        private  String descricao;
}
