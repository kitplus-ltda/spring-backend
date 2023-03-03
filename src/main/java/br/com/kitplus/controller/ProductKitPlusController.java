package br.com.kitplus.controller;


import br.com.kitplus.repository.model.ProductDTO;
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
    public ResponseEntity<HttpStatus> createProduct(@RequestBody ProductDTO productDTO) {
        this.productKitPlusService.createProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("get_products")
    public ResponseEntity<List<ProductEntity>> getProducts() {
        return new ResponseEntity<>(this.productKitPlusService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("get_product/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable String id) {
        return new ResponseEntity<>(this.productKitPlusService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("edit_product")
    public ResponseEntity<ProductEntity> editProduct(@RequestBody @Valid ProductEntity productEntity) {
        return new ResponseEntity<>(this.productKitPlusService.editProduct(productEntity), HttpStatus.OK);
    }

    @DeleteMapping("remove_all_products")
    public ResponseEntity<HttpStatus> removeAllProducts() {
        this.productKitPlusService.removeAllProducts();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ProductCategoriesEntity>> getAllCategories() {
        return new ResponseEntity<>(productKitPlusService.getAllCategories(), HttpStatus.OK);

    }

    @PostMapping("/category")
    public ResponseEntity<HttpStatus> createCategory(@Valid @RequestBody ProductCategoriesEntity category) {
        this.productKitPlusService.createCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("category/{id}")
    public ResponseEntity<HttpStatus> removeCategory(@Valid @PathVariable String id) {
        this.productKitPlusService.removeCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
