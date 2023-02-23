package br.com.kitplus.models.Clients;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerAddressRequest {
    public  String id;
    /** Zip code. */
    public  String zipCode;
    /** Street name. */
    public  String streetName = null;
    /** Street number. */
    public  String streetNumber;
}
