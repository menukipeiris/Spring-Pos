package lk.ijse.aad.spring.dao;

import lk.ijse.aad.spring.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
