package lk.ijse.thogakadepos_backend.util;

import lk.ijse.thogakadepos_backend.dto.impl.CustomerDTO;
import lk.ijse.thogakadepos_backend.dto.impl.ItemDTO;
import lk.ijse.thogakadepos_backend.dto.impl.OrderDTO;
import lk.ijse.thogakadepos_backend.dto.impl.OrderDetailsDTO;
import lk.ijse.thogakadepos_backend.entity.impl.CustomerEntity;
import lk.ijse.thogakadepos_backend.entity.impl.ItemEntity;
import lk.ijse.thogakadepos_backend.entity.impl.OrderDetailsEntity;
import lk.ijse.thogakadepos_backend.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;


    // =========== For customer mapping ===========

    //for converting Dto to Entity
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    //for converting Entity to Dto
    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    //for converting EntityList to DtoList
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customerEntityList) {
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>() {}.getType());
    }


    // =========== For item mapping ===========

    //for converting Dto to Entity
    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    //for converting Entity to Dto
    public ItemDTO toItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    //for converting EntityList to DtoList
    public List<ItemDTO> toItemDTOList(List<ItemEntity> itemEntityList) {
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDTO>>() {}.getType());
    }


    // =========== For order mapping ===========

    //for converting Dto to Entity
    public OrderEntity toOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    //for converting Entity to Dto
    public OrderDTO toOrderDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    //for converting EntityList to DtoList
    public List<OrderDTO> toOrderDTOList(List<OrderEntity> orderEntityList) {
        return modelMapper.map(orderEntityList, new TypeToken<List<OrderDTO>>() {}.getType());
    }


    // =========== For order details mapping ===========

    //for converting Dto to Entity
    public OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDTO orderDetailsDTO) {
        return modelMapper.map(orderDetailsDTO, OrderDetailsEntity.class);
    }

    //for converting Entity to Dto
    public OrderDetailsDTO toOrderDetailsDTO(OrderDetailsEntity orderDetailsEntity) {
        return modelMapper.map(orderDetailsEntity, OrderDetailsDTO.class);
    }

    //for converting EntityList to DtoList
    public List<OrderDetailsDTO> toOrderDetailsDTOList(List<OrderDetailsEntity> orderDetailsEntityList) {
        return modelMapper.map(orderDetailsEntityList, new TypeToken<List<OrderDetailsDTO>>() {}.getType());
    }

}
