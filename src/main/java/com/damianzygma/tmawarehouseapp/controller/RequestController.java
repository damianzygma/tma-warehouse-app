package com.damianzygma.tmawarehouseapp.controller;

import com.damianzygma.tmawarehouseapp.dto.RequestDto;
import com.damianzygma.tmawarehouseapp.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RequestController {


    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/admin/requests")
    public String requests(Model model){
        List<RequestDto> requests = requestService.findAllRequest();
        model.addAttribute("requests", requests);
        return "/admin/requests";
    }


}
