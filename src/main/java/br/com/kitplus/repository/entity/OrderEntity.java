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
    private String ref_rastr_entr;
    private String cod_rastr_entr;
    private int quantidade;
    private String hora_data;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserRegisterEntity user_id_pk;

    @JoinColumn(name = "address_id")
    @OneToOne
    UserAddressEntity address_id_pk;

    @JoinColumn(name = "user_sign_in")
    @OneToOne
    UserSignInEntity user_sign_in_pk;

    @OneToMany
    List<ProductEntity> product_id;
}
