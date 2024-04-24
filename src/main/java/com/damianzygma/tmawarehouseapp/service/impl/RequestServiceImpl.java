package com.damianzygma.tmawarehouseapp.service.impl;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Item;
import com.damianzygma.tmawarehouseapp.entity.Request;
import com.damianzygma.tmawarehouseapp.entity.Status;
import com.damianzygma.tmawarehouseapp.mapper.RequestMapper;
import com.damianzygma.tmawarehouseapp.repository.ItemRepository;
import com.damianzygma.tmawarehouseapp.repository.RequestRepository;
import com.damianzygma.tmawarehouseapp.repository.StatusRepository;
import com.damianzygma.tmawarehouseapp.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;

    private StatusRepository statusRepository;

    private ItemRepository itemRepository;

    public RequestServiceImpl(RequestRepository requestRepository,
                              StatusRepository statusRepository,
                              ItemRepository itemRepository) {
        this.requestRepository = requestRepository;
        this.statusRepository = statusRepository;
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

        String statusName = "New";
        Status status = statusRepository.findStatusByName(statusName);
        request.setStatus(status);

        requestRepository.save(request);
    }

    @Override
    public void rejectRequest(RequestDto requestDto) {
        Request request = RequestMapper.mapToRequest(requestDto);
        String statusName = "Rejected";
        Status status = statusRepository.findStatusByName(statusName);
        request.setStatus(status);
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

        String statusName = "Approved";
        Status status = statusRepository.findStatusByName(statusName);
        request.setStatus(status);
        request.setComment(null);
        requestRepository.save(request);
    }

    @Override
    public RequestDto findRequestById(Long requestId) {
        Request request = requestRepository.findById(requestId).get();
        return RequestMapper.mapToRequestDto(request);
    }




}
