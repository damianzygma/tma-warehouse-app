package com.damianzygma.tmawarehouseapp.service.impl;

import com.damianzygma.tmawarehouseapp.entity.ItemGroup;
import com.damianzygma.tmawarehouseapp.repository.ItemGroupRepository;
import com.damianzygma.tmawarehouseapp.service.ItemGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemGroupServiceImpl implements ItemGroupService {

    private ItemGroupRepository itemGroupRepository;


    public ItemGroupServiceImpl(ItemGroupRepository itemGroupRepository) {
        this.itemGroupRepository = itemGroupRepository;
    }


    @Override
    public List<ItemGroup> findAllItemGroups() {
        List<ItemGroup> itemGroups = itemGroupRepository.findAll();
        return itemGroups;
    }
}
