package br.com.kitplus.controller;


import br.com.kitplus.repository.entity.Product;
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
@Api(value = "API for register  and update kitplus Products")
public class ProductKitPlusController {

    @Autowired
    private ProductKitPlusService productKitPlusService;

    @PostMapping("/create_product")
    public ResponseEntity<HttpStatus> createProduct(@RequestBody Product product) {
        this.productKitPlusService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("get_products")
    public ResponseEntity<List<ProductEntity>>getProducts(){
        return new ResponseEntity<>( this.productKitPlusService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/get_categories")
    public ResponseEntity<List<ProductCategoriesEntity>> getAllCategories() {
        return new ResponseEntity<>(productKitPlusService.getAllCategories(), HttpStatus.OK);

    }

    @PostMapping("/create_category")
    public ResponseEntity<HttpStatus> createCategory(@Valid @RequestBody ProductCategoriesEntity category) {
        this.productKitPlusService.createCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("remove_category/{id}")
    public ResponseEntity<HttpStatus> createCategory(@Valid @PathVariable String id) {
        this.productKitPlusService.removeCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
