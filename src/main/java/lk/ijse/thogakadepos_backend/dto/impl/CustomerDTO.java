package lk.ijse.thogakadepos_backend.dto.impl;

import lk.ijse.thogakadepos_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO {

    private String id;
    private String name;
    private String address;
    private String phone;
    private List<OrderDTO> orders; // a customer can make more orders

}
