package lk.ijse.aad.spring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO {
    private String detailsId;
    private OrderDTO order;
    private ItemDTO item;
    private int orderQty;
    private double unitPrice;
}
