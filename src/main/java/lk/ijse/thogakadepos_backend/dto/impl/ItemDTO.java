package lk.ijse.thogakadepos_backend.dto.impl;

import lk.ijse.thogakadepos_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO {

    private String code;
    private String name;
    private double price;
    private int qty;

}
