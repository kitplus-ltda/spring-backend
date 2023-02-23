package br.com.kitplus.models.Clients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestMP {
    private  String email = null;

    /** Customer's first name. */
    private  String firstName = null;

    /** Customer's last name. */
    private  String lastName = null;

    /** Customer's phone. */
    private  Phone phone = null;

    /** Customer's identification. */
    private  Identification identification = null;

    /** Customer's default address. */
    private  String defaultAddress = null;

    /** Default address information. */
    private CustomerAddressRequest address = null;

    /** Customer's default card. */
    private  String defaultCard;

    /** Customer's registration date. */
    private  String dateRegistred;

    /** Customer's description. */
    private  String description;

    public Object builder() {
        return null;
    }


}
