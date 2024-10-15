package lk.ijse.thogakadepos_backend.controller;

import lk.ijse.thogakadepos_backend.dto.impl.ItemDTO;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.exception.ItemNotFoundException;
import lk.ijse.thogakadepos_backend.service.ItemService;
import lk.ijse.thogakadepos_backend.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
@CrossOrigin
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;


    // ----------- SAVE ITEM -----------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO){

        try{
            logger.info("The Request is received to save item : {}", itemDTO.getCode());
            if(RegexProcess.itemCodeMatcher(itemDTO.getCode())){
                itemService.saveItem(itemDTO);
                logger.info("Item {} saved successfully", itemDTO.getCode());
            }
        } catch (DataPersistException e){
            logger.error("Failed to save item: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error while saving item : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    // ----------- UPDATE ITEM -----------
    @PutMapping("/{itemId}")
    public ResponseEntity<Void> updateItem(@PathVariable ("itemId") String itemId, @RequestBody ItemDTO itemDTO){

        try{
            logger.info("The Request is received to update item : {}", itemId);
            if(!RegexProcess.itemCodeMatcher(itemId) || itemDTO == null){
                logger.warn("Invalid input data for item update");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemId, itemDTO);
            logger.info("Item {} updated successfully", itemId);
        } catch (ItemNotFoundException e){
            logger.error("Item not found for ID: {}", itemId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error("Internal server error while updating item : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ----------- DELETE ITEM -----------
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemId") String itemId){

        try{
            logger.info("The Request is received to delete item : {}", itemId);
            if(!RegexProcess.itemCodeMatcher(itemId)){
                logger.warn("Invalid item ID: {}", itemId);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemId);
            logger.info("Item {} deleted successfully", itemId);
        } catch (ItemNotFoundException e){
            logger.error("Item not found for ID: {}", itemId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error("Internal server error while deleting item : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ----------- GET ALL ITEM -----------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        logger.info("The Request is received to get all items");
        List<ItemDTO> allItems = itemService.getAllItems();
        logger.info("All items retrieved: {}", allItems.size());
        return allItems;
    }

}
