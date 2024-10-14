package lk.ijse.thogakadepos_backend.service;

import lk.ijse.thogakadepos_backend.dto.impl.OrderDetailsDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailsService {
    void saveOrderDetail(OrderDetailsDTO orderDetailsDTO);
}
