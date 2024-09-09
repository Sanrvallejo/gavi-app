package com.sena.gavi.model.entities;

import com.sena.gavi.enums.PaymentMethod;
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
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;

    /*para almacenar la fecha usamos Temporal para especificar a JPA el tipo de fecha almacenada
    elegiimos TIMESTAMP para almacenar fecha y hora */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date cretaedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    //Código de venta único (código de factura)
    private String code;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Double subtotal;
    private String total;

    @OneToMany(mappedBy = "sale")
    private List<SaleDetail> salesDetails;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Sale(Date cretaedAt, Date updatedAt, String code, PaymentMethod paymentMethod,
                Double subtotal, String total) {
        this.cretaedAt = cretaedAt;
        this.updatedAt = updatedAt;
        this.code = code;
        this.paymentMethod = paymentMethod;
        this.subtotal = subtotal;
        this.total = total;
    }
}
