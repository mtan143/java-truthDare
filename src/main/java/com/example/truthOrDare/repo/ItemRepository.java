package com.example.truthOrDare.repo;

import com.example.truthOrDare.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("select i from Item i where i.type='truth'")
    List<Item> getTruth();

    @Query("select i from Item i where i.type='dare'")
    List<Item> getDare();
}
