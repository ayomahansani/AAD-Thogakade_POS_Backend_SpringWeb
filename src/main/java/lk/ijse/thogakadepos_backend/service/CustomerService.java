package lk.ijse.thogakadepos_backend.service;

import lk.ijse.thogakadepos_backend.dto.impl.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String customerId, CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    List<CustomerDTO> getAllCustomers();
}
