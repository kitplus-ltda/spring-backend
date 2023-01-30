package br.com.kitplus.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.kitplus.models.Shippiment.dto.ShippmentRequestDTO;
import br.com.kitplus.models.Shippiment.dto.ShippmentResponseDTO;
import br.com.kitplus.service.ShippmentService;

@RestController
@RequestMapping("/api/v1/shippment")
@CrossOrigin(origins = {"https://kitplus.com.br/"})
public class ShippmentController {
    @Autowired
    private ShippmentService shippmentService;


    
    @PostMapping("/simulator")
    public ResponseEntity<ArrayList<ShippmentResponseDTO>> simulatorShippiment(@RequestBody ShippmentRequestDTO shippment)  throws Exception  { 
      
        ObjectMapper mapper = new ObjectMapper();
        ShippmentRequestDTO shippmentRequest = mapper.convertValue(shippment,
                ShippmentRequestDTO.class);

        ArrayList<ShippmentResponseDTO> shippmentResponseDTO = this.shippmentService.simulator(shippmentRequest);
        if(shippmentResponseDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shippmentResponseDTO, HttpStatus.OK);
    }

}
