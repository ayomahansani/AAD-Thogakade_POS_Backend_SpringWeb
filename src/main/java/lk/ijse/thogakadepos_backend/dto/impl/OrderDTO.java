package lk.ijse.thogakadepos_backend.dto.impl;

import lk.ijse.thogakadepos_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO {

    private String orderId;
    private Date orderDate;
    private String customerId;
    private List<ItemDTO> orderedItems;

}
