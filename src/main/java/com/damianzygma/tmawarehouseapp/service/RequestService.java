package com.damianzygma.tmawarehouseapp.service;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;

import java.util.List;

public interface RequestService {

    List<RequestDto> findAllRequest();

}
