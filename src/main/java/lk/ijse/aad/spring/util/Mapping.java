package lk.ijse.aad.spring.util;

import lk.ijse.aad.spring.dto.impl.CustomerDTO;
import lk.ijse.aad.spring.entity.impl.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public List<CustomerDTO> asUserDTOList(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities,new TypeToken<CustomerDTO>(){}.getType());
    }
}
