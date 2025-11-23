package com.probe.managesys.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.probe.managesys.models.Brand;
import com.probe.managesys.models.Electronics;
import com.probe.managesys.models.Products;

@Service
public class ProductsServices {
    
    private final List<Products> products = new ArrayList<>();

    public ProductsServices() {
        // Dados iniciais com alguns produtos eletrônicos de exemplo
        products.add(new Electronics("Smartphone", new Brand("Marca fictícia", "Alemanha"),
                "Modelo 1", "Especificação 1", "Um smartphone de última geração",
                "https://img.freepik.com/free-vector/realistic-front-view-smartphone-mockup-mobile-iphone-purple-frame-with-blank-white-display-vector_90220-959.jpg?semt=ais_hybrid&w=740&q=80", 2600.50));
        products.add(new Electronics("Notebook", new Brand("Marca fictícia 2", "Japão"),
                "Modelo 3", "Especificação 3", "Um notebook para compacto para uso profissional",
                "https://cdn.pixabay.com/photo/2014/04/02/10/13/notebook-303161_1280.png", 3500.00));
    }

    // Adiciona um novo produto
    public void addProduct(Products product) {
        products.add(product);
    }

    // Remove um produto pelo nome
    public boolean removeProduct(String name) {
        return products.removeIf(product -> product.getName().equalsIgnoreCase(name));
    }

    // Atualiza um produto existente
    public boolean updateProduct(String name, Products updatedProduct) {
        Optional<Products> existingProduct = getProductByName(name);
        if (existingProduct.isPresent()) {
            Products product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setBrand(updatedProduct.getBrand());
            product.setModel(updatedProduct.getModel());
            product.setSpecifications(updatedProduct.getSpecifications());
            product.setDescription(updatedProduct.getDescription());
            product.setImageUrl(updatedProduct.getImageUrl());
            product.setPrice(updatedProduct.getPrice());
            return true;
        }
        return false;
    }

    // Retorna todos os produtos
    public List<Products> getAllProducts(String brand, String type) {
        return products;
    }

    // Retorna todos os produtos eletrônicos
    public List<Electronics> getAllElectronics() {
        return products.stream()
                .filter(product -> product instanceof Electronics)
                .map(product -> (Electronics) product)
                .collect(Collectors.toList());
    }

    // Retorna um produto pelo nome
    public Optional<Products> getProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Retorna produtos por marca
    public List<Products> getProductsByBrand(String brandName) {
        return products.stream()
                .filter(product -> product.getBrand().getName().equalsIgnoreCase(brandName))
                .collect(Collectors.toList());
    }
}
