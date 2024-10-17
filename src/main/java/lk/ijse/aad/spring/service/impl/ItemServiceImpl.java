package lk.ijse.aad.spring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.aad.spring.customStatusCode.SelectedErrorStatus;
import lk.ijse.aad.spring.dao.ItemDao;
import lk.ijse.aad.spring.dto.ItemStatus;
import lk.ijse.aad.spring.entity.impl.ItemEntity;
import lk.ijse.aad.spring.exception.DataPersistException;
import lk.ijse.aad.spring.exception.ItemNotFoundException;
import lk.ijse.aad.spring.dto.impl.ItemDTO;
import lk.ijse.aad.spring.service.ItemService;
import lk.ijse.aad.spring.util.AppUtil;
import lk.ijse.aad.spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping itemMapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setItemId(AppUtil.generateItemID());
        ItemEntity savedItem=itemDao.save(itemMapping.toItemEntity(itemDTO));
        if(savedItem == null){
            throw new DataPersistException("Item not saved");
        }

    }

    @Override
    public List<ItemDTO> getAllItems() {
        return itemMapping.asItemDTOList(itemDao.findAll());

    }

    @Override
    public ItemStatus getItem(String itemId){
        if(itemDao.existsById(itemId)){
            var selectedItem = itemDao.getReferenceById(itemId);
            return itemMapping.toItemDTO(selectedItem);
        }else {
            return new SelectedErrorStatus(2,"Selected item not found");
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> foundNote=itemDao.findById(itemId);
        if(!foundNote.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            itemDao.deleteById(itemId);
        }

    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        Optional<ItemEntity> findItem=itemDao.findById(itemId);
        if (!findItem.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            findItem.get().setDescription(itemDTO.getDescription());
            findItem.get().setQty(itemDTO.getQty());
            findItem.get().setPrice(itemDTO.getPrice());

        }
    }
}
