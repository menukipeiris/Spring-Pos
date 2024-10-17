package lk.ijse.aad.spring.controller;

import lk.ijse.aad.spring.customStatusCode.SelectedErrorStatus;
import lk.ijse.aad.spring.dto.ItemStatus;
import lk.ijse.aad.spring.exception.CustomerNotFoundException;
import lk.ijse.aad.spring.exception.DataPersistException;
import lk.ijse.aad.spring.dto.impl.ItemDTO;
import lk.ijse.aad.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItems(@RequestBody ItemDTO itemDTO) {
        try {
            itemService.saveItem(itemDTO);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getSelectedItem(@PathVariable ("itemId") String itemId){
        String regexForUserID = "I-[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(itemId);
        if (!regexMatcher.matches()) {
            return new SelectedErrorStatus(1,"Item ID is not valid");
        }
        return itemService.getItem(itemId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @DeleteMapping({"/{itemId}"})
    public ResponseEntity<Void> deleteItems(@PathVariable("itemId") String itemId){
        String regexForUserID = "I-[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}";

        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(itemId);
        try {
            if (!regexMatcher.matches()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{itemId}")
    public ResponseEntity<Void> updateItems(@PathVariable("itemId") String itemId ,@RequestBody ItemDTO  updatedItemDTO){
        String regexForUserID = "I-[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(itemId);
        try {
            if (!regexMatcher.matches() || updatedItemDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemId, updatedItemDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
