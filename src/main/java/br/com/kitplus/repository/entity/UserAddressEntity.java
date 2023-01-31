package br.com.kitplus.repository.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_address",
        indexes = {
                @Index(columnList = "id, document_number"),
                @Index(columnList = "document_number")
        })

public class UserAddressEntity implements Serializable  {
    private static final long serialVersionUID = -1905907502453138175L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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

//    @Column(name = "document_number", nullable = false)
//    @Size(max = 255)
//    public String document_number;

    @ManyToOne
    @JoinColumn(name = "document_number" , referencedColumnName = "document_number")
    private UserRegisterEntity document_number;
}


