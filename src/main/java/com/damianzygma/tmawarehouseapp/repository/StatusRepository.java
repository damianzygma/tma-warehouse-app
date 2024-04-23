package com.damianzygma.tmawarehouseapp.repository;

import com.damianzygma.tmawarehouseapp.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long> {

    Status findStatusByName(String statusName);

}
