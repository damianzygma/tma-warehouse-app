package com.damianzygma.tmawarehouseapp.repository;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Item;
import com.damianzygma.tmawarehouseapp.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request,Long> {

    @Query(value = "SELECT requests.id, requests.employee_id, requests.item_id, items.unit_id, requests.quantity, items.price, requests.status_id, requests.comment\n" +
            "FROM requests\n" +
            "INNER JOIN items ON requests.item_id = items.id", nativeQuery = true)
    Optional<Request> findAllRequest();

    Optional<Request> findById(Long id);



}
