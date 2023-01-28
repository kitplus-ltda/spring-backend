
package br.com.kitplus.models.Shippiment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippmentRequestVolumeDTO {
    private Number peso;
    private Number altura;
    private Number largura;
    private Number comprimento;
    private String tipo;
    private Number valor;
    private Number quantidade;

}