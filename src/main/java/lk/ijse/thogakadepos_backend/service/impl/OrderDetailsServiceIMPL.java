package lk.ijse.thogakadepos_backend.service.impl;

import lk.ijse.thogakadepos_backend.dao.OrderDetailsDAO;
import lk.ijse.thogakadepos_backend.dto.impl.OrderDetailsDTO;
import lk.ijse.thogakadepos_backend.entity.impl.OrderDetailsEntity;
import lk.ijse.thogakadepos_backend.entity.impl.OrderEntity;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.service.OrderDetailsService;
import lk.ijse.thogakadepos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailsServiceIMPL implements OrderDetailsService {

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private Mapping mapping;


    @Override
    public void saveOrderDetail(OrderDetailsDTO orderDetailsDTO) {
        OrderDetailsEntity savedOrderDetailsEntity = orderDetailsDAO.save(mapping.toOrderDetailsEntity(orderDetailsDTO));
        if(savedOrderDetailsEntity == null){
            throw new DataPersistException("Order Detail not saved");
        }
    }
}
