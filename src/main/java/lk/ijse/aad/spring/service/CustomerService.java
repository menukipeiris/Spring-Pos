package lk.ijse.aad.spring.service;

import lk.ijse.aad.spring.dto.CustomerStatus;
import lk.ijse.aad.spring.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerStatus getCustomer(String customerId);
    void deleteCustomer(String customerId);
    void updateCustomer(String customerId,CustomerDTO customerDTO);
}
