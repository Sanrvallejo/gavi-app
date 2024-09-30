package com.sena.gavi.model.repository;

import com.sena.gavi.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findById(UUID id);
    Optional<Product> getByCode(String code);
}
