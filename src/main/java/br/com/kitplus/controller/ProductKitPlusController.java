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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<ProductCategoriesEntity>> getAllCategories() {
        return new ResponseEntity<>(productKitPlusService.getAllCategories(), HttpStatus.OK);

    }

    @PostMapping("/create_category")
    public ResponseEntity<HttpStatus> createCategory(@Valid @RequestParam String category) {
        this.productKitPlusService.createCategory(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
