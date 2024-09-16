package com.sena.gavi.model.repository;

import com.sena.gavi.model.entities.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, String>
{
}
