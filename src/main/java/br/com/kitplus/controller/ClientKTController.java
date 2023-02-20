package br.com.kitplus.controller;

import br.com.kitplus.service.ClientKitplusService;
import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;



@Slf4j
@RestController
@Controller
@RequestMapping("/api/kitplus/v1")
@Api(value = "API for register and update kitplus user")
public class ClientKTController  {

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
        return new ResponseEntity<>(clientKitplusService.registerClientKitPlus(clientRegister), HttpStatus.CREATED);
    }
}
