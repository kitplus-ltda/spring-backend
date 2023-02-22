package br.com.kitplus.repository.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ApiModel
@Table(name = "user_address")

public class UserAddressEntity implements Serializable {
    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id", nullable = false)
    private Long address_id;

    @Column(name = "street", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String street;

    @Column(name = "neighborhood", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String neighborhood;

    @Column(name = "city", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String city;

    @Column(name = "state", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String state;

    @Column(name = "zipcode", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String zipcode;

    @Column(name = "number", nullable = false)
    @Size(max = 255)
    @ApiModelProperty
    public String number;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    UserRegisterEntity user_id_pk;

}


