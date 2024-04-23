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

    @GetMapping("/admin/requests")
    public String requests(Model model){
        List<RequestDto> requests = requestService.findAllRequest();
        model.addAttribute("requests", requests);
        return "/admin/requests";
    }

    @GetMapping("admin/items/{itemId}/order")
    public String newRequestForm(@PathVariable("itemId") Long itemId,
                             Model model){
        ItemDto itemDto = itemService.findItemById(itemId);
        model.addAttribute("item", itemDto);
        RequestDto requestDto = new RequestDto();
        model.addAttribute("request", requestDto);
        return "admin/create_request";
    }

    @PostMapping("/admin/items/{itemId}/order")
    public String createRequest(@PathVariable("itemId") Long itemId,
                                @ModelAttribute("request") RequestDto requestDto){
        requestService.createRequest(itemId, requestDto);
        return "redirect:/admin/requests";

    }
    @GetMapping("admin/requests/{requestId}/reject")
    public String rejectRequestForm(@PathVariable("requestId") Long requestId,
                                Model model){
        RequestDto requestDto = requestService.findRequestById(requestId);
        model.addAttribute("request", requestDto);
        return "admin/reject_request";
    }

    @PostMapping("admin/requests")
    public String rejectRequest(@ModelAttribute("request") RequestDto requestDto){
        requestService.rejectRequest(requestDto);
        return "redirect:/admin/requests";
    }

    @GetMapping("admin/requests/{requestId}/confirm")
    public String confirmRequest(@PathVariable("requestId") Long requestId){
        RequestDto requestDto = requestService.findRequestById(requestId);
        requestService.confirmRequest(requestDto);
        return "redirect:/admin/requests";
    }





}
