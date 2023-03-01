package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tbl_categories")
public class ProductCategoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long category_id;
    String name;

}
