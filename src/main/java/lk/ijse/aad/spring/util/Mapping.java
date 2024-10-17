package lk.ijse.aad.spring.util;

import lk.ijse.aad.spring.dto.impl.OrderDetailsDTO;
import lk.ijse.aad.spring.entity.impl.CustomerEntity;
import lk.ijse.aad.spring.entity.impl.ItemEntity;
import lk.ijse.aad.spring.entity.impl.OrderDetailsEntity;
import lk.ijse.aad.spring.entity.impl.OrderEntity;
import lk.ijse.aad.spring.dto.impl.CustomerDTO;
import lk.ijse.aad.spring.dto.impl.ItemDTO;
import lk.ijse.aad.spring.dto.impl.OrderDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //for customer mapping
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public List<CustomerDTO> asCustomerDTOList(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities,new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //for item mapping
    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO,ItemEntity.class);
    }

    public ItemDTO toItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public List<ItemDTO> asItemDTOList(List<ItemEntity> itemEntities) {
        return modelMapper.map(itemEntities,new TypeToken<List<ItemDTO>>() {}.getType());
    }

    //For order
    public OrderEntity toOrderEntity(OrderDTO orderDTO){
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    //For Order Details
    public OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDTO orderDetailsDTO){
        return modelMapper.map(orderDetailsDTO,OrderDetailsEntity.class);
    }

    public List<OrderDetailsDTO> asOrderDetailsDTOList(List<OrderDetailsEntity> orderDetailsEntities){
        return modelMapper.map(orderDetailsEntities,new TypeToken<List<OrderDetailsDTO>>() {}.getType());
    }


}
