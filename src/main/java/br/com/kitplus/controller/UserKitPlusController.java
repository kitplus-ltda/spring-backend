package br.com.kitplus.controller;

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
@RequestMapping("/api/v1/kitplus")
public class UserKitPlusController extends ErrorsStack {

    @Autowired
    RegisterServices registerServices;


    @GetMapping("/user/{id}")
    public ResponseEntity<Client> getUserById(@PathVariable Integer id) throws Exception {
        Client user = registerServices.getClientDetails(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("user/register")
    public ResponseEntity<Client> postCreateUser(@Valid @RequestBody Client clientRegister) throws Exception {
        Client response = registerServices.postCreateUser(clientRegister);
        if (this.errorStackTratement(response.getErrorInfo()) != null) {
            response.setErrorInfo(errorStackTratement(response.getErrorInfo()));
        }
        return new ResponseEntity<>(response, this.errorStatusTratement(response.getErrorInfo()));
    }
}
