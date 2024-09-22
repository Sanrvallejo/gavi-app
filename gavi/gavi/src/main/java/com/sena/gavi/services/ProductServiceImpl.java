package com.sena.gavi.services;

import com.sena.gavi.model.entities.Product;
import com.sena.gavi.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
            product.setCretaedAt(new Date());
            product.setUpdatedAt(new Date());
            product.setState(true);
            product.setStock(0.0);
            System.out.println("Product:" + product);
            return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }
}
