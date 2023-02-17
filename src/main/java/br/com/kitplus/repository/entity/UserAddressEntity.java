package br.com.kitplus.repository.entity;


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
@Table(name = "user_address")

public class UserAddressEntity implements Serializable {
    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id", nullable = false)
    private Long address_id;

    @Column(name = "street", nullable = false)
    @Size(max = 255)
    public String street;

    @Column(name = "neighborhood", nullable = false)
    @Size(max = 255)
    public String neighborhood;

    @Column(name = "city", nullable = false)
    @Size(max = 255)
    public String city;

    @Column(name = "state", nullable = false)
    @Size(max = 255)
    public String state;

    @Column(name = "zipcode", nullable = false)
    @Size(max = 255)
    public String zipcode;

    @Column(name = "number", nullable = false)
    @Size(max = 255)
    public String number;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    UserRegisterEntity user_id_pk;

}


