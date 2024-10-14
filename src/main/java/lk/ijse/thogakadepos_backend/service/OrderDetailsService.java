package lk.ijse.thogakadepos_backend.service;

import lk.ijse.thogakadepos_backend.dto.impl.OrderDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailsService {
    void saveOrderDetail(OrderDetailsDTO orderDetailsDTO);
    List<OrderDetailsDTO> getAllOrderDetails();
    List<OrderDetailsDTO> getOrderDetailsByOrderId(String orderId);

}
