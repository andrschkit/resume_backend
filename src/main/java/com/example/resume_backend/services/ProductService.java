package com.example.resume_backend.services;

import com.example.resume_backend.entities.Product;
import com.example.resume_backend.exceptions.NotFoundException;
import com.example.resume_backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.resume_backend.utils.StaticStrings.NOT_FOUND_EXCEPTION_PRODUCT;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository;}

    public Product findProductById(Long id) {return productRepository.findById(id)
            .orElseThrow(()-> new NotFoundException(NOT_FOUND_EXCEPTION_PRODUCT, id.toString()));}

    public ArrayList<Product> findAllProducts() {return productRepository.findAllByOrderByIdAsc();}
}
