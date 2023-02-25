package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tbl_categories")
public class ProductCategoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long category_id;
    String name;
}
