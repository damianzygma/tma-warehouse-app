package com.damianzygma.tmawarehouseapp.service.impl;

import com.damianzygma.tmawarehouseapp.dto.ItemDto;
import com.damianzygma.tmawarehouseapp.entity.Item;
import com.damianzygma.tmawarehouseapp.mapper.ItemMapper;
import com.damianzygma.tmawarehouseapp.repository.ItemRepository;
import com.damianzygma.tmawarehouseapp.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDto> findAllItems() {
        List<Item> items =  itemRepository.findAll();
        return items.stream().map((item) -> ItemMapper.mapToItemDto(item))
                .collect(Collectors.toList());
    }

    @Override
    public void createItem(ItemDto itemDto) {
        Item item = ItemMapper.mapToItem(itemDto);
        itemRepository.save(item);

    }

    @Override
    public ItemDto findItemById(Long itemId) {
        Item item = itemRepository.findById(itemId).get();
        return ItemMapper.mapToItemDto(item);
    }

    @Override
    public void updateItem(ItemDto itemDto) {
        Item item = ItemMapper.mapToItem(itemDto);
        itemRepository.save(item);
    }

    @Override
    public void deleteItemById(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
