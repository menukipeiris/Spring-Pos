package lk.ijse.aad.spring.dao;

import lk.ijse.aad.spring.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ItemDao extends JpaRepository<ItemEntity, String> {
}
