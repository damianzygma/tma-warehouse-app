package com.damianzygma.tmawarehouseapp.mapper;

import com.damianzygma.tmawarehouseapp.dto.ItemDto;
import com.damianzygma.tmawarehouseapp.entity.Item;

public class ItemMapper {

    // map Item entity to ItemDto
    public static ItemDto mapToItemDto(Item item){
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .itemGroup(item.getItemGroup())
                .unit(item.getUnit())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .status(item.getStatus())
                .storage(item.getStorage())
                .contact(item.getContact())
                .build();
    }

    // map ItemDto to Item entity
    public static Item mapToItem(ItemDto itemDto){
        return Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .itemGroup(itemDto.getItemGroup())
                .unit(itemDto.getUnit())
                .quantity(itemDto.getQuantity())
                .price(itemDto.getPrice())
                .status(itemDto.getStatus())
                .storage(itemDto.getStorage())
                .contact(itemDto.getContact())
                .build();
    }

}
