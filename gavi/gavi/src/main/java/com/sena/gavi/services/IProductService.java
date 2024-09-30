package com.sena.gavi.services;

import com.sena.gavi.model.entities.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductService {
    Product save(Product product);
    Optional<Product> getProduct(UUID id);
    Optional<Product> getByCode(String code);
    List<Product> getAllProducts();
    void update(Product incomingProduct, Product foundProduct);
}
