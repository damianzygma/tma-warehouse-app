package com.damianzygma.tmawarehouseapp.mapper;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Request;

public class RequestMapper {

    public static RequestDto mapToRequestDto (Request request) {
        return RequestDto.builder()
                .id(request.getId())
                .employeeName(request.getEmployeeName())
                .item(request.getItem())
                .quantity(request.getQuantity())
                .requestStatus(request.getRequestStatus())
                .comment(request.getComment())
                .build();
    }

    public static Request mapToRequest (RequestDto requestDto) {
        return Request.builder()
                .id(requestDto.getId())
                .employeeName(requestDto.getEmployeeName())
                .item(requestDto.getItem())
                .quantity(requestDto.getQuantity())
                .requestStatus(requestDto.getRequestStatus())
                .comment((requestDto.getComment()))
                .build();
    }


}
