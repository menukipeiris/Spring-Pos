package lk.ijse.aad.spring.customStatusCode;

import lk.ijse.aad.spring.dto.CustomerStatus;
import lk.ijse.aad.spring.dto.ItemStatus;
import lk.ijse.aad.spring.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SelectedErrorStatus implements CustomerStatus, ItemStatus, OrderStatus {
    private int statusCode;
    private String statusMessage;
}
