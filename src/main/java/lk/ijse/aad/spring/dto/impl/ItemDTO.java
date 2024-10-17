package lk.ijse.aad.spring.dto.impl;

import lk.ijse.aad.spring.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDTO implements ItemStatus {
    private String itemId;
    private String description;
    private int qty;
    private double price;
}
