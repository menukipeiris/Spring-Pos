package lk.ijse.aad.spring.entity.impl;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.aad.spring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")

public class CustomerEntity implements SuperEntity {
    @Id
    private String cust_id;
    private String cust_name;
    private String cust_address;
    private String cust_salary;
}
