package lk.ijse.thogakadepos_backend.controller;

import lk.ijse.thogakadepos_backend.dto.impl.OrderDetailsDTO;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.service.OrderDetailsService;
import lk.ijse.thogakadepos_backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
