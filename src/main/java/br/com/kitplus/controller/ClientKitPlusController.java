package br.com.kitplus.controller;

import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.service.ClientKitplusService;
import br.com.kitplus.repository.entity.Client;
import br.com.kitplus.repository.service.RegisterService;
import com.mercadopago.resources.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@Slf4j
@RestController
@Controller
@RequestMapping("/api/kitplus/v1/client")
@Api(value = "API for registerClient and update kitplus user")
public class ClientKitPlusController {

    @Autowired
    RegisterService registerService;

    @Autowired
    ClientKitplusService clientKitplusService;


    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> getUserById(@PathVariable Integer id) throws Exception {
        //registerServices.getClientDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@Valid @RequestBody Client clientRegister) throws Exception {
        clientKitplusService.registerClientKitPlus(clientRegister);
        Customer customer = clientKitplusService.searchCreateUserMP(clientRegister);

        if (!Objects.equals(customer, null)) {
            String id = clientKitplusService.updateClient(clientRegister, customer.getId());
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        if (clientRegister.getClientDetails().getIdPaymentIntegration() != null) {
            return new ResponseEntity<>(clientRegister.getClientDetails().getIdPaymentIntegration(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>("CREATED ", HttpStatus.CREATED);
    }

    @GetMapping("/order_by_user/{userId}")
    public ResponseEntity<List<ResumeOrderDTO>> getOrderByUser (@PathVariable String userId){
        List<ResumeOrderDTO> orders =  clientKitplusService.getOrderByUser(userId);
       return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
