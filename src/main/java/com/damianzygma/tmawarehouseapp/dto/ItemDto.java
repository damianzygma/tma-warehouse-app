package com.damianzygma.tmawarehouseapp.dto;

import com.damianzygma.tmawarehouseapp.entity.Group;
import com.damianzygma.tmawarehouseapp.entity.Storage;
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
    private Group group;
    private Unit unit;
    private Long quantity;
    private Double price;
    private String status;
    private Storage storage;
    private String contact;


}
