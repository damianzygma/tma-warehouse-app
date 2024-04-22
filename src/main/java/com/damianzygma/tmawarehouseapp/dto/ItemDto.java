package com.damianzygma.tmawarehouseapp.dto;

import com.damianzygma.tmawarehouseapp.entity.ItemGroup;
import com.damianzygma.tmawarehouseapp.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Long id;
    private String name;
    private ItemGroup itemGroup;
    private Unit unit;
    private Long quantity;
    private Double price;
    private String status;
    private String storage;
    private String contact;


}
