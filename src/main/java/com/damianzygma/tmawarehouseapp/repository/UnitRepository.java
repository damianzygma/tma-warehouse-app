package com.damianzygma.tmawarehouseapp.repository;

import com.damianzygma.tmawarehouseapp.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit,Long> {

    Unit findByName(String name);

}
