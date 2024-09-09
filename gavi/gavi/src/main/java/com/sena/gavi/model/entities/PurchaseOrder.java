package com.sena.gavi.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;

    //para almacenar la fecha usamos Temporal para especificar a JPA el tipo de fecha almacenada
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    private String code;
    private Double subtotal;
    private Double taxes;
    private Double total;

    @OneToMany(mappedBy = "purchaseDetail")
    private List<PurchaseDetail> purchasesDetails;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public PurchaseOrder(Date createdAt, Date updatedAt, String code, Double subtotal, Double taxes, Double total) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.code = code;
        this.subtotal = subtotal;
        this.taxes = taxes;
        this.total = total;
    }


}
