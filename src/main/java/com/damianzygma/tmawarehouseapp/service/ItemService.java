package com.damianzygma.tmawarehouseapp.service;

import com.damianzygma.tmawarehouseapp.dto.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> findAllItems();
}
