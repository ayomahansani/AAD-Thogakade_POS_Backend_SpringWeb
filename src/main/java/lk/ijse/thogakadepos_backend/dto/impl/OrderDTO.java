package lk.ijse.thogakadepos_backend.dto.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.thogakadepos_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO {

    private String orderId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private String customerId;
    private List<ItemDTO> orderedItems;

}
