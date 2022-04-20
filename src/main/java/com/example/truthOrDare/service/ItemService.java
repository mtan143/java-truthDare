package com.example.truthOrDare.service;

import com.example.truthOrDare.model.Item;
import com.example.truthOrDare.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<Item> save(Item item) throws Exception {

        if (item.getContent().isEmpty() || item.getType().isEmpty())
            throw new Exception("Missing some field's information ");
        return ResponseEntity.ok(itemRepository.save(item));
    }

    public ResponseEntity<List<Item>> getAll() {
        return ResponseEntity.ok(itemRepository.findAll());
    }

    public ResponseEntity<Item> getById(Integer id) {
        return ResponseEntity.ok(itemRepository.findById(id).get());
    }

    public ResponseEntity<Item> update(Item item, Integer id) throws Exception {

        Item existItem = itemRepository.getById(id);
        if (Objects.isNull(existItem)) throw new Exception("Id not found!");

        existItem.setContent(item.getContent());
        existItem.setType(item.getType());

        return this.save(existItem);
    }

    public ResponseEntity delete(Integer id) throws Exception {

        Item existItem = itemRepository.getById(id);
        if (Objects.isNull(existItem)) throw new Exception("Id not found!");

        itemRepository.delete(existItem);
        return ResponseEntity.ok("Delete Successfully!");
    }

    public ResponseEntity deleteAll() {
        itemRepository.deleteAll();
        return ResponseEntity.ok("Delete Successfully!");
    }

    public List<Item> getTruth() {
        return itemRepository.getTruth();
    }

    public List<Item> getDare() {
        return itemRepository.getDare();
    }

}
