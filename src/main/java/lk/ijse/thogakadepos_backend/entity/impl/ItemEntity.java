package lk.ijse.thogakadepos_backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.thogakadepos_backend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity implements SuperEntity {

    @Id
    private String code;
    private String name;
    private double price;
    private int qty;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderDetails;

}
