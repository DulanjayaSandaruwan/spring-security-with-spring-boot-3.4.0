package com.example.spring_security.controller;

import com.example.spring_security.dto.AddProductRequest;
import com.example.spring_security.dto.ProductDTO;
import com.example.spring_security.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody AddProductRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }
}
