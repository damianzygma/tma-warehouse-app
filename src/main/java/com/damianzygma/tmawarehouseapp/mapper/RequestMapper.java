package com.damianzygma.tmawarehouseapp.mapper;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Request;

public class RequestMapper {

    public static RequestDto mapToRequestDto (Request request) {
        return RequestDto.builder()
                .id(request.getId())
                .employee(request.getEmployee())
                .item(request.getItem())
                .quantity(request.getQuantity())
                .status(request.getStatus())
                .comment(request.getComment())
                .build();
    }

    public static Request mapToRequest (RequestDto requestDto) {
        return Request.builder()
                .id(requestDto.getId())
                .employee(requestDto.getEmployee())
                .item(requestDto.getItem())
                .quantity(requestDto.getQuantity())
                .status(requestDto.getStatus())
                .comment((requestDto.getComment()))
                .build();
    }


}
