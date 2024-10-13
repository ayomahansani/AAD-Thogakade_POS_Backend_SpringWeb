package lk.ijse.thogakadepos_backend.service;

import lk.ijse.thogakadepos_backend.dto.impl.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(String itemId, ItemDTO itemDTO);
    void deleteItem(String itemId);
    List<ItemDTO> getAllItems();
}
