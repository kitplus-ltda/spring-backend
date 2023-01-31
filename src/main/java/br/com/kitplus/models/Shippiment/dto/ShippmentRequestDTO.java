package br.com.kitplus.models.Shippiment.dto;

import java.util.ArrayList;

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
public class ShippmentRequestDTO {
  private String cepOrigem;
  private String cepDestino;
  private Number vlrMerc;
  private Number pesoMerc;
  private ArrayList<ShippmentRequestVolumeDTO> volumes;
  private ArrayList<ShippmentRequestProductDTO> produtos;
  private ArrayList<String> servicos;
  private String ordernar;
}
