package lk.ijse.aad.spring.dto.impl;

import lk.ijse.aad.spring.dto.RequestOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDTO implements RequestOrderStatus {
    private OrderDTO order;
    private List<OrderDetailsDTO> orderDetails;
}
