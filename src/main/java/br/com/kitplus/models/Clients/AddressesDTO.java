package br.com.kitplus.models.Clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressesDTO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("street_name")
    private String street_name;

    @ApiModelProperty("street_number")
    private BigDecimal street_number;

    @ApiModelProperty("zip_code")
    private String zip_code;

    @ApiModelProperty("city")
    private String city;

}
