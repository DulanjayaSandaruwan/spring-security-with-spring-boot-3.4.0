package com.example.spring_security.service;

import com.example.spring_security.dto.AddProductRequest;
import com.example.spring_security.dto.ProductDTO;
import com.example.spring_security.entity.Product;
import com.example.spring_security.mapper.ProductMapper;
import com.example.spring_security.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO addProduct(AddProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }
}
