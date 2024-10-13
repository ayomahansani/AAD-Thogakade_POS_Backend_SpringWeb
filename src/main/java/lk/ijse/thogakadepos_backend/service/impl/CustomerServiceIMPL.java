package lk.ijse.thogakadepos_backend.service.impl;

import lk.ijse.thogakadepos_backend.dao.CustomerDAO;
import lk.ijse.thogakadepos_backend.dto.impl.CustomerDTO;
import lk.ijse.thogakadepos_backend.entity.impl.CustomerEntity;
import lk.ijse.thogakadepos_backend.exception.CustomerNotFoundException;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.service.CustomerService;
import lk.ijse.thogakadepos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private Mapping mapping;


    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity saveCustomerEntity = customerDAO.save(mapping.toCustomerEntity(customerDTO));
        if(saveCustomerEntity == null){
            throw new DataPersistException("Customer not saved");
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> foundCustomerEntity = customerDAO.findById(customerId);
        if(!foundCustomerEntity.isPresent()){
            throw new CustomerNotFoundException("Customer not found");
        } else {
            foundCustomerEntity.get().setId(customerDTO.getId());
            foundCustomerEntity.get().setName(customerDTO.getName());
            foundCustomerEntity.get().setAddress(customerDTO.getAddress());
            foundCustomerEntity.get().setPhone(customerDTO.getPhone());
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> foundCustomerEntity = customerDAO.findById(customerId);
        if(!foundCustomerEntity.isPresent()){
            throw new CustomerNotFoundException("Customer not found");
        } else {
            customerDAO.deleteById(customerId);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> allCustomers = customerDAO.findAll();
        return mapping.toCustomerDTOList(allCustomers);
    }
}
