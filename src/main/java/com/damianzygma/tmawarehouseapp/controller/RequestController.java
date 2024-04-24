package com.damianzygma.tmawarehouseapp.controller;

import com.damianzygma.tmawarehouseapp.dto.ItemDto;
import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.entity.Request;
import com.damianzygma.tmawarehouseapp.service.ItemService;
import com.damianzygma.tmawarehouseapp.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RequestController {


    private RequestService requestService;

    private ItemService itemService;

    public RequestController(RequestService requestService, ItemService itemService) {
        this.requestService = requestService;
        this.itemService = itemService;
    }

    @GetMapping("/coordinator/requests")
    public String requests(Model model){
        List<RequestDto> requests = requestService.findAllRequest();
        model.addAttribute("requests", requests);
        return "/coordinator/requests";
    }

    @GetMapping("/employee/requests")
    public String requestsEmployee(Model model){
        List<RequestDto> requests = requestService.findAllRequest();
        model.addAttribute("requests", requests);
        return "/employee/requests";
    }


    @GetMapping("employee/items/{itemId}/order")
    public String newRequestFormEmployee(@PathVariable("itemId") Long itemId,
                                 Model model){
        ItemDto itemDto = itemService.findItemById(itemId);
        model.addAttribute("item", itemDto);
        RequestDto requestDto = new RequestDto();
        model.addAttribute("request", requestDto);
        return "employee/create_request";
    }

    @PostMapping("/employee/items/{itemId}/order")
    public String createRequestEmployee(@PathVariable("itemId") Long itemId,
                                @ModelAttribute("request") RequestDto requestDto){
        requestService.createRequest(itemId, requestDto);
        return "redirect:/employee/items";
    }

    @GetMapping("coordinator/requests/{requestId}/reject")
    public String rejectRequestForm(@PathVariable("requestId") Long requestId,
                                Model model){
        RequestDto requestDto = requestService.findRequestById(requestId);
        model.addAttribute("request", requestDto);
        return "coordinator/reject_request";
    }

    @PostMapping("coordinator/requests")
    public String rejectRequest(@ModelAttribute("request") RequestDto requestDto){
        requestService.rejectRequest(requestDto);
        return "redirect:/coordinator/requests";
    }

    @GetMapping("coordinator/requests/{requestId}/confirm")
    public String confirmRequest(@PathVariable("requestId") Long requestId){
        RequestDto requestDto = requestService.findRequestById(requestId);
        requestService.confirmRequest(requestDto);
        return "redirect:/coordinator/requests";
    }





}
