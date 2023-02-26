package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter

@Table(name = "tbl_product")

public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id", nullable = false)
    private Long product_id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 755)
    private String descricao;

    @Column(length = 755)
    private String detalhes;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(length = 755)
    private String caracteristicas;

    private int promocional;

    @Column(nullable = false)
    private int comprimento;

    @Column(nullable = false)
    private int largura;

    @Column(nullable = false)
    private int altura;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private int peso;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "category", nullable = false)
    ProductCategoriesEntity category_id;

}
