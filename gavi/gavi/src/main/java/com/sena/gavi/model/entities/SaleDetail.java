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
@Table(name = "sales_details")
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Column(name = "sale_code")
    private String saleCode;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_code")
    private String codeProduct;

    @Column(name = "product_name")
    private String nameProduct;

    private Double quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "total_price")
    private Double totalPrice;
}
