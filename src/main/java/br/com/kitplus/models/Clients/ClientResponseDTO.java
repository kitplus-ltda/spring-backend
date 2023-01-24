package br.com.kitplus.models.Clients;


import br.com.kitplus.models.ResponseResult;
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
public class ClientResponseDTO extends ResponseResult<AddressMainDTO> {

        private String last_name;
        private String live_mode;
        private Phone phone;
}

