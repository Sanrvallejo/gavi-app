package com.sena.gavi.services;

import com.sena.gavi.model.entities.Sale;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ISalesService {
    Optional<Sale> findById(UUID id);
    void create(Sale sale);
    List<Sale> findAll();
}
