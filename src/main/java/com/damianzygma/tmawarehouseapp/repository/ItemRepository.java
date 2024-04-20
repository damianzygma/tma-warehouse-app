package com.damianzygma.tmawarehouseapp.repository;

import com.damianzygma.tmawarehouseapp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {

    Optional<Item> findById(Long id);

}
