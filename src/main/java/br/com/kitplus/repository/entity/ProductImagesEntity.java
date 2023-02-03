package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tbl_images")
public class ProductImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long image_id;
    String image;

    @ManyToOne
    @JoinColumn(name="product_id")
    ProductEntity product_id_pk;
}
