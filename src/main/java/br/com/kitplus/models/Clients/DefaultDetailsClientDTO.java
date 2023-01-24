package br.com.kitplus.models.Clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultDetailsClientDTO {
    private String date_created;
    private String date_last_updated;
    private String default_address;
    private String default_card;
    private String email;
    private String first_name;
    private String id;
    private Identification identification;
}
