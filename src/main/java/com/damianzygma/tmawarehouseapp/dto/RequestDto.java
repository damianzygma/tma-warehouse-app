package com.damianzygma.tmawarehouseapp.dto;

import com.damianzygma.tmawarehouseapp.entity.Employee;
import com.damianzygma.tmawarehouseapp.entity.Item;
import com.damianzygma.tmawarehouseapp.entity.Status;
import com.damianzygma.tmawarehouseapp.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDto {

    private Long id;
    private Employee employee;
    private Item item;
    private Long quantity;
    private Status status;
    private String comment;

}
