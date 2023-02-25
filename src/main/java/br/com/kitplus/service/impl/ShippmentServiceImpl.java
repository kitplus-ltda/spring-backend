package br.com.kitplus.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.inject.internal.ErrorsException;

import br.com.kitplus.models.Shippiment.dto.ShippmentRequestDTO;
import br.com.kitplus.models.Shippiment.dto.ShippmentResponseDTO;
import br.com.kitplus.service.ShippmentService;

@Service
public class ShippmentServiceImpl implements ShippmentService {

    /* (non-Javadoc)
     * @see br.com.kitplus.service.ShippmentService#simulator(br.com.kitplus.models.Shippiment.dto.ShippmentRequestDTO)
     */
    @Override
    public ArrayList<ShippmentResponseDTO> simulator(ShippmentRequestDTO request) throws IOException, ErrorsException {


        Gson gson = new Gson();

        String jsonBody = gson.toJson(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Token", "a30e8570e1128a388e6ee168e7c6eb042c92547af485bedbe124d7801ab72e06");

        HttpEntity<String> entity = new HttpEntity(jsonBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList> result = restTemplate.postForEntity(
                "https://portal.kangu.com.br/tms/transporte/simular", entity, ArrayList.class);

        final ArrayList<ShippmentResponseDTO> shippmentResponseDTOs = (ArrayList<ShippmentResponseDTO>) result.getBody();
        return  shippmentResponseDTOs;

    }

}
