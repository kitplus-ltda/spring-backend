package br.com.kitplus.models.Clients;

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
public class Identification {
    @ApiModelProperty("Document Number")
    private String number;

    @ApiModelProperty("Type of Document")
    private String type;

}
