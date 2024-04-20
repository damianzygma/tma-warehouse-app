package com.damianzygma.tmawarehouseapp.controller;

import com.damianzygma.tmawarehouseapp.dto.ItemDto;
import com.damianzygma.tmawarehouseapp.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/admin/home")
    public String items(Model model){
        List<ItemDto> items = itemService.findAllItems();
        model.addAttribute("items", items);
        return "/admin/home";
    }

}
