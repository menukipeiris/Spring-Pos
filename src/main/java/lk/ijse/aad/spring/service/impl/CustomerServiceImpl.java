package lk.ijse.aad.spring.service;

import lk.ijse.aad.spring.impl.CustomerDTO;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        return "";
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerDTO getCustomer(String customerId) {
        return null;
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        return false;
    }

    @Override
    public boolean updateCustomer(String customerId, CustomerDTO customerDTO) {
        return false;
    }
}
