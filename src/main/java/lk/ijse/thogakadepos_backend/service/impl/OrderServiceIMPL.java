package lk.ijse.thogakadepos_backend.service.impl;

import lk.ijse.thogakadepos_backend.dao.OrderDAO;
import lk.ijse.thogakadepos_backend.dto.impl.OrderDTO;
import lk.ijse.thogakadepos_backend.entity.impl.OrderEntity;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.service.OrderService;
import lk.ijse.thogakadepos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private Mapping mapping;


    @Override
    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity saveOrderEntity = orderDAO.save(mapping.toOrderEntity(orderDTO));
        if(saveOrderEntity == null){
            throw new DataPersistException("Order not saved");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> allOrders = orderDAO.findAll();
        return mapping.toOrderDTOList(allOrders);
    }
}
