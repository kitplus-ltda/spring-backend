package br.com.kitplus.controller;


import br.com.kitplus.repository.entity.ProductEntity;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/kitplus/v1/products")
@Api(value = "API for registerClient and update kitplus user")
public class ProductKitPlusController {

    @PostMapping("/create_product")
    public void createProduct(ProductEntity product){
        //TODO CALL METHOD FOR SAVE IN DATA BASE
    }

}
