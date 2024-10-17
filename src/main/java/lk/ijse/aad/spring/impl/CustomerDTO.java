package lk.ijse.aad.spring.dto.impl;

import lk.ijse.aad.spring.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO implements CustomerStatus {
    private String cust_id;
    private String cust_name;
    private String cust_address;
    private String cust_salary;
}
