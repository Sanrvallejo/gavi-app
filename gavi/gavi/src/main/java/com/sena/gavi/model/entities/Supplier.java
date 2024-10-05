package com.sena.gavi.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;

    private String name;

    private String nit;

    private String city;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<PurchaseDetail> purchasesdetails;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Supplier(String name, String nit, String city) {
        this.name = name;
        this.nit = nit;
        this.city = city;
    }
}
