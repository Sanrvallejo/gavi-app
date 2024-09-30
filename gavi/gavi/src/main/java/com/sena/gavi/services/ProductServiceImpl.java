package com.sena.gavi.services;

import com.sena.gavi.model.entities.Product;
import com.sena.gavi.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<Product> getProduct(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getByCode(String code) {
        return productRepository.getByCode(code);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void update(Product incomingProduct, Product foundProduct) {

        //actualizar el producto
        System.out.println("Incoming product: " + incomingProduct);

        foundProduct.setUpdatedAt(new Date());
        foundProduct.setCode(incomingProduct.getCode());
        foundProduct.setName(incomingProduct.getName());
        foundProduct.setCategory(incomingProduct.getCategory());
        foundProduct.setUnit(incomingProduct.getUnit());
        foundProduct.setStock(incomingProduct.getStock());
        foundProduct.setCost(incomingProduct.getCost());
        foundProduct.setTax(incomingProduct.getTax());
        foundProduct.setValueTax(incomingProduct.getValueTax());
        foundProduct.setProfit(incomingProduct.getProfit());
        foundProduct.setPrice(incomingProduct.getPrice());
        foundProduct.setState(incomingProduct.isState());

        //guardar el producto actualizado en la base de datos
        System.out.println("Product updated:" + foundProduct);
        productRepository.save(foundProduct);
    }
}
