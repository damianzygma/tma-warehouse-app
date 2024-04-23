package com.damianzygma.tmawarehouseapp.service;

import com.damianzygma.tmawarehouseapp.dto.ItemDto;
import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Item;

import java.util.List;

public interface RequestService {

    List<RequestDto> findAllRequest();

    void createRequest (Long itemId, RequestDto requestDto);

    void rejectRequest(RequestDto requestDto);

    void confirmRequest(RequestDto requestDto);

    RequestDto findRequestById(Long requestId);





}
