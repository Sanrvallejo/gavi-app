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
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;

    private String name;
    private String nit;
    private String address;
    private String phoneNumber;

    //CascadeType.ALL nos servirá para afectar los cambios del padre en los hijos
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<UsersInStore> users;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Sale> sales;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<PurchaseOrder> purchases;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Supplier> suppliers;


}
