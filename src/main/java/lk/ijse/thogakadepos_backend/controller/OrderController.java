package lk.ijse.thogakadepos_backend.controller;

import lk.ijse.thogakadepos_backend.dto.impl.OrderDTO;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;


    // ----------- SAVE ORDER -----------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO orderDTO){

        try{
            logger.info("The Request is received to save order : {}", orderDTO.getOrderId());
            orderService.saveOrder(orderDTO);
            logger.info("Order {} saved successfully", orderDTO.getOrderId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e){
            logger.error("Failed to save order: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error while saving order : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    // ----------- GET ALL ORDERS -----------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        logger.info("The Request is received to get all orders");
        List<OrderDTO> allOrders = orderService.getAllOrders();
        logger.info("All orders retrieved: {}", allOrders.size());
        return allOrders;
    }

}
