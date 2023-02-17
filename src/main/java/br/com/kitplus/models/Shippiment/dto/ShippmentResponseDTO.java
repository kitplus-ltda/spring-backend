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
public class ShippmentResponseDTO {
    private Number vlrFrete;
    private Number prazoEnt;
    private String dtPrevEnt;
    private ArrayList<ShippmentResponseTariff> tarifas;
    private ShippmentResponseErrorDTO error;
    private Number idSimulacao;
    private Number idTransp;
    private String cnpjTransp;
    private Number idTranspResp;
    private String cnpjTranspResp;
    private String alertas;
    private String nf_obrig;
    private String url_logo;
    private String transp_nome;
    private String descricao;
    private String servico;
    private String referencia;
}
