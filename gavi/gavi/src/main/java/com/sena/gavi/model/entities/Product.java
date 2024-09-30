package com.sena.gavi.model.entities;

import com.sena.gavi.enums.Category;
import com.sena.gavi.enums.Tax;
import com.sena.gavi.enums.Units;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;

    //para almacenar la fecha usamos Temporal para especificar a JPA el tipo de fecha almacenada
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    @ToString.Include
    private Date cretaedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    @ToString.Include
    private Date updatedAt;

    //estado del produto para cuando se lo elimine -> por defecto activo cuando es creado
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean state;

    //código único para el producto (puede ser el código de barras)
    @Column(unique=true)
    @ToString.Include
    private String code;

    @ToString.Include
    private String name;

    @Enumerated(EnumType.STRING)
    @ToString.Include
    private Category category;

    //por defecto es 0.0 cuando se crea el producto
    @Column(columnDefinition = "DOUBLE PRECISION")
    @ToString.Include
    private Double stock;

    //medida en la que se guardará y venderá el producto
    @Enumerated(EnumType.STRING)
    @ToString.Include
    private Units unit;

    @ToString.Include
    private Double cost;

    //tipo de impuesto que paga
    @Enumerated(EnumType.STRING)
    @ToString.Include
    private Tax tax;

    //valor del impuesto
    @Column(name = "value_tax")
    @ToString.Include
    private Double valueTax;

    @ToString.Include
    private Double profit;

    @ToString.Include
    private Double price;

    //Por defecto ya tiene el FETCH.EAGER para cargar automáticamente la entidad relacionada
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = true)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = true)
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
