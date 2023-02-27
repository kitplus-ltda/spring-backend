package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.List;


@ApiModel
@Getter
@Setter
public class Product {
    private String nome;

    private String descricao;

    private String detalhes;

    private BigDecimal preco;

    private String caracteristicas;

    private int promocional;

    private int comprimento;

    private int largura;

    private int altura;

    private int quantidade;

    private int peso;

    private Long category_id;

    private List<ProductImage> productImages;

}
