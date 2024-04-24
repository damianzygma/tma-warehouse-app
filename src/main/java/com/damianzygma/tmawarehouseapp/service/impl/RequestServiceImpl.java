package com.damianzygma.tmawarehouseapp.service.impl;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Item;
import com.damianzygma.tmawarehouseapp.entity.Request;
import com.damianzygma.tmawarehouseapp.mapper.RequestMapper;
import com.damianzygma.tmawarehouseapp.repository.ItemRepository;
import com.damianzygma.tmawarehouseapp.repository.RequestRepository;
import com.damianzygma.tmawarehouseapp.service.RequestService;
import com.damianzygma.tmawarehouseapp.util.RequestStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;
    private ItemRepository itemRepository;

    public RequestServiceImpl(RequestRepository requestRepository,
                              ItemRepository itemRepository) {
        this.requestRepository = requestRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<RequestDto> findAllRequest() {
        List<Request> requests = requestRepository.findAll();
        return requests.stream().map((request -> RequestMapper.mapToRequestDto(request)))
                .collect(Collectors.toList());
    }

    @Override
    public void createRequest(Long itemId, RequestDto requestDto) {
        Item item = itemRepository.findById(itemId).get();
        Request request = RequestMapper.mapToRequest(requestDto);
        request.setItem(item);
        request.setRequestStatus(RequestStatus.NEW);
        requestRepository.save(request);
    }

    @Override
    public void rejectRequest(RequestDto requestDto) {
        Request request = RequestMapper.mapToRequest(requestDto);
        request.setRequestStatus(RequestStatus.REJECTED);
        requestRepository.save(request);
    }

    @Override
    public void confirmRequest(RequestDto requestDto) {
        Request request = RequestMapper.mapToRequest(requestDto);
        Item itemFromRequest = request.getItem();
        Long itemFromRequestQuantity = itemFromRequest.getQuantity();
        Long requestQuantity = request.getQuantity();
        Long itemQuantityAfterConfirm = itemFromRequestQuantity - requestQuantity;
        itemFromRequest.setQuantity(itemQuantityAfterConfirm);
        request.setRequestStatus(RequestStatus.APPROVED);
        request.setComment(null);
        requestRepository.save(request);
    }

    @Override
    public RequestDto findRequestById(Long requestId) {
        Request request = requestRepository.findById(requestId).get();
        return RequestMapper.mapToRequestDto(request);
    }




}
