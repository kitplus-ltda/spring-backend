package br.com.kitplus.controller;

import br.com.kitplus.service.ClientKitplusService;
import br.com.kitplus.utils.ErrorsStack;
import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class UserKitPlusController extends ErrorsStack {

    @Autowired
    RegisterServices registerServices;

    @Autowired
    ClientKitplusService clientKitplusService;


    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> getUserById(@PathVariable Integer id) throws Exception {
        //registerServices.getClientDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create_user")
    public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody Client clientRegister) throws Exception {
        clientKitplusService.registerClientKitPlus(clientRegister);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
