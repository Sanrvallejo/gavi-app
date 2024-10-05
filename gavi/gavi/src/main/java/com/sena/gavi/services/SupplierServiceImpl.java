package com.sena.gavi.services;

import com.sena.gavi.model.entities.Supplier;
import com.sena.gavi.model.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierServiceImpl  implements ISupplierService{

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Optional<Supplier> findById(UUID id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void create(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public void update(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}
