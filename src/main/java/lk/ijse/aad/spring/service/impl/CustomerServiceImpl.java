package lk.ijse.aad.spring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.aad.spring.customStatusCode.SelectedErrorStatus;
import lk.ijse.aad.spring.dao.CustomerDao;
import lk.ijse.aad.spring.dto.CustomerStatus;
import lk.ijse.aad.spring.entity.impl.CustomerEntity;
import lk.ijse.aad.spring.exception.CustomerNotFoundException;
import lk.ijse.aad.spring.exception.DataPersistException;
import lk.ijse.aad.spring.dto.impl.CustomerDTO;
import lk.ijse.aad.spring.service.CustomerService;
import lk.ijse.aad.spring.util.AppUtil;
import lk.ijse.aad.spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Mapping customerMapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
      customerDTO.setCustId(AppUtil.generateCustomerID());
      CustomerEntity savedCustomer=customerDao.save(customerMapping.toCustomerEntity(customerDTO));
        if(savedCustomer == null){
            throw new DataPersistException("Customer not saved");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerMapping.asCustomerDTOList(customerDao.findAll());
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        if(customerDao.existsById(customerId)){
            var selectedUser = customerDao.getReferenceById(customerId);
            return customerMapping.toCustomerDTO(selectedUser);
        }else {
            return new SelectedErrorStatus(2,"Selected customer not found");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> foundNote=customerDao.findById(customerId);
        if(!foundNote.isPresent()){
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDao.deleteById(customerId);
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {

        Optional<CustomerEntity> findCustomer=customerDao.findById(customerId);
        if (!findCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer not found");
        }else {
            findCustomer.get().setCustName(customerDTO.getCustName());
            findCustomer.get().setCustAddress(customerDTO.getCustAddress());
            findCustomer.get().setCustSalary(customerDTO.getCustSalary());
        }
    }
}
