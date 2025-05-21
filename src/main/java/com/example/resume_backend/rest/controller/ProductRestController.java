package com.example.resume_backend.rest.controller;

import com.example.resume_backend.entities.Product;
import com.example.resume_backend.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.example.resume_backend.utils.Endpoints.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Контроллер продуктов", description = "Взаимодейтсивие с продуктами")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Получить продукт по ID",
            description = "Позволяет получить конкретный продукт по ID",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_PRODUCT_ID)
    public Product getProductById(
            @PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long id) {
        return productService.findProductById(id);
    }

    @Operation(
            summary = "Получить все продукты",
            description = "Позволяет получить все продукты из БД",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_PRODUCTS)
    public ArrayList<Product> getAllProducts() {
        return productService.findAllProducts();
    }
}
