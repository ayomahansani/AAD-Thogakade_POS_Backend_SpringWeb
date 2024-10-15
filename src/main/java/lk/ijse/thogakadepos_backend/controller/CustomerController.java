package lk.ijse.thogakadepos_backend.controller;

import lk.ijse.thogakadepos_backend.dto.impl.CustomerDTO;
import lk.ijse.thogakadepos_backend.exception.CustomerNotFoundException;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.service.CustomerService;
import lk.ijse.thogakadepos_backend.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@CrossOrigin
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;


    // ----------- SAVE CUSTOMER -----------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDTO customerDTO){

        try{
            logger.info("The Request is received to save customer : {}", customerDTO.getId());
            if(RegexProcess.customerIdMatcher(customerDTO.getId())){
                customerService.saveCustomer(customerDTO);
                logger.info("Customer {} saved successfully", customerDTO.getId());
            }
        } catch (DataPersistException e){
            logger.error("Failed to save customer: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error while saving customer : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    // ----------- UPDATE CUSTOMER -----------
    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable ("customerId") String customerId, @RequestBody CustomerDTO customerDTO){

        try{
            logger.info("The Request is received to update customer : {}", customerId);
            if(!RegexProcess.customerIdMatcher(customerId) || customerDTO == null){
                logger.warn("Invalid input data for customer update");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(customerId, customerDTO);
            logger.info("Customer {} updated successfully", customerId);
        } catch (CustomerNotFoundException e){
            logger.error("Customer not found for ID: {}", customerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error("Internal server error while updating customer : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ----------- DELETE CUSTOMER -----------
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable ("customerId") String customerId){

        try{
            logger.info("The Request is received to delete customer : {}", customerId);
            if(!RegexProcess.customerIdMatcher(customerId)){
                logger.warn("Invalid customer ID: {}", customerId);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(customerId);
            logger.info("Customer {} deleted successfully", customerId);
        } catch (CustomerNotFoundException e){
            logger.error("Customer not found for ID: {}", customerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error("Internal server error while deleting customer : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ----------- GET ALL CUSTOMERS -----------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        logger.info("The Request is received to get all customers");
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        logger.info("All customers retrieved: {}", allCustomers.size());
        return allCustomers;
    }


}
