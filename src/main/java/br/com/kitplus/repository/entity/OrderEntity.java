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

@Table(name = "tbl_order")

public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order", nullable = false)
    private Long id_order;

    @Column
    private String ref_rastr_entr;

    @Column
    private String cod_rastr_entr;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private String hora_data;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id"  , nullable = false)
    UserRegisterEntity user_id_pk;

    @JoinColumn(name = "address_id", nullable = false)
    @OneToOne
    UserAddressEntity address_id_pk;

    @JoinColumn(name = "user_sign_in", nullable = false)
    @OneToOne
    UserSignInEntity user_sign_in_pk;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    ProductEntity product_id;
}
