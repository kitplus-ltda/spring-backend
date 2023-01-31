package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_register")
public class UserRegisterEntity {
    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    @Size(max = 255)
    public String name;

    @Column(name = "last_name", nullable = false)
    @Size(max = 255)
    public String lastName;

    @Column(name = "document_type", nullable = false)
    @Size(max = 255)
    public String documentType;

    @Column(name = "document_number", unique = true, nullable = false)
    @Size(max = 255)
    public String documentNumber;

    @Column(name = "user_email", unique = true, nullable = false)
    @Size(max = 255)
    public String email;

    @Column(name = "id_mp", unique = true, nullable = false)
    @Size(max = 255)
    public String idPaymentIntegration;

    @OneToMany
    private List<UserAddressEntity> userAddressEntities;

    @OneToOne
    private UserSignInEntity userSignInEntity;
}


