package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tbl_param_error")
public class ErrorEntity implements Serializable {

    @Id
    Long id;

    @Column
    String erro;

    @Column
    @Size(max = 1024)
    String descricao;

}
