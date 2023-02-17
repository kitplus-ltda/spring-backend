package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tbl_videos")
public class ProductVideosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long video_id;
    String video;

    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductEntity product_id_pk;
}
