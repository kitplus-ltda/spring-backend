package br.com.kitplus.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import br.com.kitplus.models.Shippiment.dto.ShippmentRequestDTO;
import br.com.kitplus.models.Shippiment.dto.ShippmentResponseDTO;

@Service
@Configurable
public interface ShippmentService {
    
    ArrayList<ShippmentResponseDTO> simulator(ShippmentRequestDTO request) throws Exception ;
}
