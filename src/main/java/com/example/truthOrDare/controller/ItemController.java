package com.example.truthOrDare.controller;

import com.example.truthOrDare.model.Item;
import com.example.truthOrDare.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> save(@RequestBody Item item) throws Exception {
        return itemService.save(item);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return itemService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@RequestBody Item item,
                                       @PathVariable Integer id) throws Exception {
        return itemService.update(item, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws Exception {
        return itemService.delete(id);
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        return itemService.deleteAll();
    }

    @GetMapping("/truth")
    public List<Item> getTruth() {
        return itemService.getTruth();
    }

    @GetMapping("/dare")
    public List<Item> getDare() {
        return itemService.getDare();
    }

}
