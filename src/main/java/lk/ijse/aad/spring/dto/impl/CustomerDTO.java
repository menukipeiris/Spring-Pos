package lk.ijse.aad.spring.dto.impl;

import lk.ijse.aad.spring.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO implements CustomerStatus {
    private String custId;
    private String custName;
    private String custAddress;
    private String custSalary;
}
