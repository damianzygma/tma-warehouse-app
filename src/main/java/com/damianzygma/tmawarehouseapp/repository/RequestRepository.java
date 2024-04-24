package com.damianzygma.tmawarehouseapp.repository;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Item;
import com.damianzygma.tmawarehouseapp.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request,Long> {

    Optional<Request> findById(Long id);



}
