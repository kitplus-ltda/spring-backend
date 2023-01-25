package br.com.kitplus.models.Clients;

import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.common.PhoneRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private  String email;

    /** Customer's first name. */
    private  String firstName;

    /** Customer's last name. */
    private  String lastName;

    /** Customer's phone. */
    private  Phone phone;

    /** Customer's identification. */
    private  Identification identification;

    /** Customer's default address. */
    private  String defaultAddress;

    /** Default address information. */
    private CustomerAddressRequest address;

    /** Customer's default card. */
    private  String defaultCard;

    /** Customer's registration date. */
    private  String dateRegistred;

    /** Customer's description. */
    private  String description;


}
