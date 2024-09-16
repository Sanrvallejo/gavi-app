package com.sena.gavi.services;

import com.sena.gavi.model.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product save(Product product);
    Optional<Product> getProduct(String id);
    List<Product> getAllProducts();
    void update(Product product);
}
