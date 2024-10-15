package lk.ijse.thogakadepos_backend.controller;

import lk.ijse.thogakadepos_backend.dto.impl.OrderDTO;
import lk.ijse.thogakadepos_backend.dto.impl.OrderDetailsDTO;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.service.OrderDetailsService;
import lk.ijse.thogakadepos_backend.util.AppUtil;
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

    @Autowired
    private OrderDetailsService orderDetailsService;


    // ----------- SAVE ORDER DETAIL -----------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrderDetail(@RequestBody OrderDetailsDTO orderDetailsDTO){

        try{
            orderDetailsDTO.setTransactionId(AppUtil.generateTransactionId());
            orderDetailsService.saveOrderDetail(orderDetailsDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    // ----------- GET ALL ORDER DETAILS -----------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailsDTO> getAllOrderDetails(){

        return orderDetailsService.getAllOrderDetails();
    }


    // ----------- GET SELECTED ORDER DETAILS -----------
    @GetMapping("/{orderId}")
    public ResponseEntity<List<OrderDetailsDTO>> getOrderDetails(@PathVariable ("orderId") String orderId) {
        List<OrderDetailsDTO> details = orderDetailsService.getOrderDetailsByOrderId(orderId);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

}
