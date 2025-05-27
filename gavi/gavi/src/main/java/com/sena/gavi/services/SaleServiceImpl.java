package com.sena.gavi.services;

import com.sena.gavi.model.entities.Sale;
import com.sena.gavi.model.repository.SaleDetailRepository;
import com.sena.gavi.model.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SaleServiceImpl implements ISalesService{

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleDetailRepository detailRepository;

    @Override
    public Optional<Sale> findById(UUID id) {
        return saleRepository.findById(id);
    }

    @Override
    public void create(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }
}
