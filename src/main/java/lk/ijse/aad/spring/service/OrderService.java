package lk.ijse.aad.spring.service;

import lk.ijse.aad.spring.dto.impl.OrderDTO;
import lk.ijse.aad.spring.dto.impl.OrderDetailsDTO;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOS);
    List<OrderDetailsDTO> getAllDetails();
//    OrderStatus getOrder(String orderId);
//    void deleteOrder(String orderId);
//    void updateOrder(String orderId,OrderDTO orderDTO);
}
