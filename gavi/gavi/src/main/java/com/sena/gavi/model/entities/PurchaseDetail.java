package com.sena.gavi.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchases_details")
public class PurchaseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private PurchaseOrder purchaseDetail;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double quantity;

    @Column(name= "product_cost")
    private double productCost;

    @Column(name = "unit_price")
    private double unitPrice;

    private double tax;

    @Column(name = "total_price")
    private double totalPrice;
}
