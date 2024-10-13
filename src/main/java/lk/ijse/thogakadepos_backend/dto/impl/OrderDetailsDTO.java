package lk.ijse.thogakadepos_backend.dto.impl;

import lk.ijse.thogakadepos_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO implements SuperDTO {

    private String transactionId;
    private double totalPrice;
    private double discount;
    private double subTotal;
    private String orderId;
    private String ItemCode;

}
