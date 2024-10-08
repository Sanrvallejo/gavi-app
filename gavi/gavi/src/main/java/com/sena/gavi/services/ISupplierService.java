package com.sena.gavi.services;

import com.sena.gavi.model.entities.Supplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ISupplierService {
    Optional<Supplier> findById(UUID id);
    void create (Supplier supplier);
    List<Supplier> findAll();
    void update (Supplier incomingSupplier, Supplier foundSupplier);
}
