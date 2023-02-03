package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter

@Table(name = "tbl_product")

public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long product_id;
    private Long nome;

    @Column(length = 755)
    private String descricao;

    @Column(length = 755)
    private String detalhes;
    private BigDecimal preco;


    @Column(length = 755)
    private String caracteristicas;

    private Long categoria_id;

    private int promocional;

    private int comprimento;

    private int largura;

    private int altura;

    private int quantidade;

    private int peso;

    @OneToOne
    @JoinColumn(name = "category_id", nullable = false)
    ProductCategoriesEntity category_id_pk;

}
