package lk.ijse.thogakadepos_backend.controller;

import lk.ijse.thogakadepos_backend.dto.impl.OrderDTO;
import lk.ijse.thogakadepos_backend.dto.impl.OrderDetailsDTO;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.service.OrderDetailsService;
import lk.ijse.thogakadepos_backend.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderDetails")
@CrossOrigin
public class OrderDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);

    @Autowired
    private OrderDetailsService orderDetailsService;


    // ----------- SAVE ORDER DETAIL -----------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrderDetail(@RequestBody OrderDetailsDTO orderDetailsDTO){

        try{
            logger.info("The Request is received to save order item detail");
            orderDetailsDTO.setTransactionId(AppUtil.generateTransactionId());
            orderDetailsService.saveOrderDetail(orderDetailsDTO);
            logger.info("Order Item Detail {} saved successfully",orderDetailsDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e){
            logger.error("Failed to save order item detail: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error while saving order item detail : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    // ----------- GET ALL ORDER DETAILS -----------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailsDTO> getAllOrderDetails(){
        logger.info("The Request is received to get all order item details");
        List<OrderDetailsDTO> allOrderDetails = orderDetailsService.getAllOrderDetails();
        logger.info("All order item details retrieved: {}", allOrderDetails.size());
        return allOrderDetails;
    }


    // ----------- GET SELECTED ORDER DETAILS -----------
    @GetMapping(value = "/{orderId}")
    public ResponseEntity<List<OrderDetailsDTO>> getOrderDetails(@PathVariable ("orderId") String orderId) {
        logger.info("The Request is received to get order detail by ID: {}", orderId);
        List<OrderDetailsDTO> details = orderDetailsService.getOrderDetailsByOrderId(orderId);
        logger.info("Order Item Detail with ID {} retrieved", orderId);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

}
