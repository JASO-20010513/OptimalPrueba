package com.optimal.crudbackend.controller;

import com.optimal.crudbackend.model.Item;
import com.optimal.crudbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        
        return itemService.findById(id)
                .map(item -> ResponseEntity.ok().body(item))
                .orElse(ResponseEntity.notFound().build());
        
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        
        return itemService.findById(id)
                .map(item -> {
                    item.setName(itemDetails.getName());
                    Item updatedItem = itemService.save(item);
                    return ResponseEntity.ok(updatedItem);
                })
                .orElse(ResponseEntity.notFound().build());
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        
        itemService.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }
    
}
