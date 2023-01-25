package br.com.kitplus.models.Clients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerAddressRequest {
    public  String id;
    /** Zip code. */
    public  String zipCode;
    /** Street name. */
    public  String streetName;
    /** Street number. */
    public  Integer streetNumber;
}
