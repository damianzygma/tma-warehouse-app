package com.damianzygma.tmawarehouseapp.service.impl;

import com.damianzygma.tmawarehouseapp.entity.Unit;
import com.damianzygma.tmawarehouseapp.repository.UnitRepository;
import com.damianzygma.tmawarehouseapp.service.UnitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    private UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Unit> findAllUnits() {
        List<Unit> units = unitRepository.findAll();
        return units;
    }
}
