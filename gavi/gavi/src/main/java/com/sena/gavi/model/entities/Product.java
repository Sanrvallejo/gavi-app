package com.sena.gavi.model.entities;

import com.sena.gavi.enums.Category;
import com.sena.gavi.enums.Tax;
import com.sena.gavi.enums.Units;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private String id;

    //para almacenar la fecha usamos Temporal para especificar a JPA el tipo de fecha almacenada
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date cretaedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    //estado del produto para cuando se lo elimine
    private boolean state;
    //código único para el producto (puede ser el código de barras)
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Double stock;

    //medida en la que se guardará y venderá el producto
    @Enumerated(EnumType.STRING)
    private Units unit;

    private Double cost;

    //tipo de impuesto que paga
    @Enumerated(EnumType.STRING)
    private Tax tax;

    //valor del impuesto
    @Column(name = "value_tax")
    private Double valueTax;
    private Double profit;
    private Double price;

    //Por defecto ya tiene el FETCH.EAGER para cargar automáticamente la entidad relacionada
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    //Entidad intermedia para la relación entre productos y ventas
    @OneToMany(mappedBy = "product")
    private List<SaleDetail> saleDetails;

    //Entidad intermedia para la relación entre productos y compras
    @OneToMany(mappedBy = "product")
    private List<PurchaseDetail> purchaseDetails;

    public Product(Date cretaedAt, Date updatedAt, boolean state, String code, String name, Category category,
                   Double stock, Units unit, Double cost, Tax tax, Double valueTax, Double profit, Double price) {
        this.cretaedAt = cretaedAt;
        this.updatedAt = updatedAt;
        this.state = state;
        this.code = code;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.unit = unit;
        this.cost = cost;
        this.tax = tax;
        this.valueTax = valueTax;
        this.profit = profit;
        this.price = price;
    }
}
