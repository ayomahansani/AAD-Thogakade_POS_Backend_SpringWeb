package lk.ijse.thogakadepos_backend.controller;

import lk.ijse.thogakadepos_backend.dto.impl.ItemDTO;
import lk.ijse.thogakadepos_backend.exception.DataPersistException;
import lk.ijse.thogakadepos_backend.exception.ItemNotFoundException;
import lk.ijse.thogakadepos_backend.service.ItemService;
import lk.ijse.thogakadepos_backend.util.RegexProcess;
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

    @Autowired
    private ItemService itemService;

    // ----------- SAVE ITEM -----------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO){

        try{
            if(RegexProcess.customerIdMatcher(itemDTO.getCode())){
                itemService.saveItem(itemDTO);
            }
        } catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    // ----------- UPDATE ITEM -----------
    @PutMapping("/{itemId}")
    public ResponseEntity<Void> updateItem(@PathVariable ("itemId") String itemId, @RequestBody ItemDTO itemDTO){

        try{
            if(RegexProcess.customerIdMatcher(itemId)){
                itemService.updateItem(itemId, itemDTO);
            }
        } catch (ItemNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ----------- DELETE ITEM -----------
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemId") String itemId){

        try{
            if(RegexProcess.customerIdMatcher(itemId)){
                itemService.deleteItem(itemId);
            }
        } catch (ItemNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ----------- GET ALL ITEM -----------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){

        return itemService.getAllItems();
    }

}
