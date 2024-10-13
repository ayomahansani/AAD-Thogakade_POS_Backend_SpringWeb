package lk.ijse.thogakadepos_backend.service.impl;

import lk.ijse.thogakadepos_backend.dao.ItemDAO;
import lk.ijse.thogakadepos_backend.dto.impl.ItemDTO;
import lk.ijse.thogakadepos_backend.entity.impl.ItemEntity;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.exception.ItemNotFoundException;
import lk.ijse.thogakadepos_backend.service.ItemService;
import lk.ijse.thogakadepos_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity saveItemEntity = itemDAO.save(mapping.toItemEntity(itemDTO));
        if(saveItemEntity == null){
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        Optional<ItemEntity> foundItemEntity = itemDAO.findById(itemId);
        if(!foundItemEntity.isPresent()){
            throw new ItemNotFoundException("Item not found");
        } else {
            foundItemEntity.get().setCode(itemDTO.getCode());
            foundItemEntity.get().setName(itemDTO.getName());
            foundItemEntity.get().setPrice(itemDTO.getPrice());
            foundItemEntity.get().setQty(itemDTO.getQty());
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> foundItemEntity = itemDAO.findById(itemId);
        if(!foundItemEntity.isPresent()){
            throw new ItemNotFoundException("Item not found");
        } else {
            itemDAO.deleteById(itemId);
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> allItems = itemDAO.findAll();
        return mapping.toItemDTOList(allItems);
    }
}
