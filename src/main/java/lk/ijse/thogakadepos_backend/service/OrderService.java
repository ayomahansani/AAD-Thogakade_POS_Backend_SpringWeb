package lk.ijse.thogakadepos_backend.service;

import lk.ijse.thogakadepos_backend.dto.impl.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
}
