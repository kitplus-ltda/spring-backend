package br.com.kitplus.repository.entity;


import io.swagger.annotations.ApiModel;
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
@ApiModel
@Table(name = "user_sign_in")
public class UserSignInEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_sign_id", nullable = false)
    private Long user_sign_id;

    @Column(name = "password")
    @Size(max = 255)
    @ApiModelProperty
    public String password;

    @Column(name = "user", unique = true)
    @Size(max = 255)
    @ApiModelProperty
    public String user;

    @Column(name = "email", unique = true)
    @Size(max = 255)
    @ApiModelProperty
    public String email;

    @ManyToOne
    UserRegisterEntity user_id_pk;

}


