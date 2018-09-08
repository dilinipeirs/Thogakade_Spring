package lk.ijse.absd.thogakade.controller;

import lk.ijse.absd.thogakade.dto.ItemDTO;
import lk.ijse.absd.thogakade.service.custom.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        return itemService.findAll();
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO findItem(@PathVariable("id") String id){
        return itemService.find(Integer.parseInt(id));
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") String id){
        itemService.delete(Integer.parseInt(id));
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveItem(@PathVariable("id") String id,
                             @RequestBody ItemDTO itemDTO){
        itemService.save(Integer.parseInt(id),itemDTO);
    }

    @PostMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@PathVariable("id") String id,
                               @RequestBody ItemDTO itemDTO){
        itemService.update(Integer.parseInt(id),itemDTO);
    }
}
