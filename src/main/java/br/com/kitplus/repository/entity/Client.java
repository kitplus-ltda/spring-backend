package br.com.kitplus.repository.entity;

import br.com.kitplus.repository.entity.UserAddressEntity;
import br.com.kitplus.repository.entity.UserRegisterEntity;
import br.com.kitplus.repository.entity.UserSignInEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@ApiModel
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_details_user_id" )
    UserRegisterEntity clientDetails;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_address_address_id")
    UserAddressEntity clientAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_sign_user_sign_id")
    UserSignInEntity userSign;
}
