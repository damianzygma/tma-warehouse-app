package com.damianzygma.tmawarehouseapp.service.impl;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Request;
import com.damianzygma.tmawarehouseapp.mapper.RequestMapper;
import com.damianzygma.tmawarehouseapp.repository.RequestRepository;
import com.damianzygma.tmawarehouseapp.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<RequestDto> findAllRequest() {
        List<Request> requests = requestRepository.findAll();
        return requests.stream().map((request -> RequestMapper.mapToRequestDto(request)))
                .collect(Collectors.toList());
    }

}
