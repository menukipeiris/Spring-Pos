package lk.ijse.aad.spring.service;

import lk.ijse.aad.spring.dto.ItemStatus;
import lk.ijse.aad.spring.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    List<ItemDTO> getAllItems();
    ItemStatus getItem(String itemId);
    void deleteItem(String itemId);
    void updateItem(String itemId,ItemDTO itemDTO);
}
