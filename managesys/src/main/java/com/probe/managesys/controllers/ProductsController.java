package com.probe.managesys.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.probe.managesys.models.Products;
import com.probe.managesys.services.ProductsServices;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    private final ProductsServices productsServices;

    public ProductsController(ProductsServices productsServices) {
        this.productsServices = productsServices;
    }

    // Retorna todos os produtos, com filtros opcionais por marca
    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(
            @RequestParam(required = false) String brand) {

        // Sempre retorna todos os produtos inicialmente, após isso aplica o filtro, caso existam
        List<Products> products = productsServices.getAllProducts(null, null);

        java.util.stream.Stream<Products> stream = products.stream();

        if (brand != null && !brand.isEmpty()) {
            stream = stream.filter(p -> p.getBrand() != null && brand.equalsIgnoreCase(String.valueOf(p.getBrand())));
        }

        List<Products> filtered = stream.collect(java.util.stream.Collectors.toList());

        if (filtered.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    // Retorna um produto pelo nome
    @GetMapping("/{name}")
    public ResponseEntity<Products> getProductByName(@PathVariable String name) {
        Optional<Products> product = productsServices.getProductByName(name);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Adiciona um novo produto
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Products product) {
        productsServices.addProduct(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    // Atualiza um produto existente
    @PutMapping("/{name}")
    public ResponseEntity<String> updateProduct(@PathVariable String name, @RequestBody Products updatedProduct) {
        boolean isUpdated = productsServices.updateProduct(name, updatedProduct);
        if (isUpdated) {
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    // Remove um produto pelo nome
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteProduct(@PathVariable String name) {
        boolean isDeleted = productsServices.removeProduct(name);
        if (isDeleted) {
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
