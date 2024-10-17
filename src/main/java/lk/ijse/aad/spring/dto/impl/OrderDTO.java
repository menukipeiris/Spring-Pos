package lk.ijse.aad.spring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDTO {
    private String orderId;
    private String customerId;
    private LocalDate date;
    private List<OrderDetailsDTO> orderDetails;
}
