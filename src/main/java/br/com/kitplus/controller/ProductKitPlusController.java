package br.com.kitplus.controller;


import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import br.com.kitplus.service.ProductKitPlusService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/kitplus/v1/product")
@Api(value = "API for registerClient and update kitplus user")
public class ProductKitPlusController {

    @Autowired
    private ProductKitPlusService productKitPlusService;

    @PostMapping("/create_product")
    public ResponseEntity<HttpStatus> createProduct(ProductEntity product) {
        this.productKitPlusService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
        //TODO CALL METHOD FOR SAVE IN DATA BASE
    }

    @GetMapping("/get_categories")
    public ResponseEntity<List<ProductCategoriesEntity>> getAllCategories(){
        return new ResponseEntity<>( productKitPlusService.getAllCategories(), HttpStatus.OK);

    }

}
