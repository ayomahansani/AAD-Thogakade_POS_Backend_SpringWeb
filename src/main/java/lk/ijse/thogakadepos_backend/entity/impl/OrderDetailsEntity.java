package lk.ijse.thogakadepos_backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.thogakadepos_backend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity implements SuperEntity {

    @Id
    private String transactionId;
    private double totalPrice;
    private double discount;
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "item_code", nullable = false)
    private ItemEntity item;

}
