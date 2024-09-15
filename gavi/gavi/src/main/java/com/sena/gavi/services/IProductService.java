package com.sena.gavi.services;

import com.sena.gavi.model.entities.Product;

import java.util.Optional;

public interface IProductService {
    Product save(Product product);
    Optional<Product> getProduct(String id);
    void update(Product product);
}
