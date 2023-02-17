package br.com.kitplus.repository.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_register")
public class UserRegisterEntity {
    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "name", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String name;

    @Column(name = "last_name", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String lastName;

    @Column(name = "document_type", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String documentType;

    @Column(name = "document_number", unique = true, nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String documentNumber;

    @Column(name = "user_email", unique = true, nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String email;

    @Column(name = "id_mp", unique = true, nullable = true)
    @Size(max = 255)
    @ApiModelProperty
    public String idPaymentIntegration;

}

