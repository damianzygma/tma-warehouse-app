package com.damianzygma.tmawarehouseapp.controller;

import com.damianzygma.tmawarehouseapp.dto.ItemDto;
import com.damianzygma.tmawarehouseapp.entity.ItemGroup;
import com.damianzygma.tmawarehouseapp.entity.Unit;
import com.damianzygma.tmawarehouseapp.service.ItemGroupService;
import com.damianzygma.tmawarehouseapp.service.ItemService;
import com.damianzygma.tmawarehouseapp.service.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemController {

    private ItemService itemService;

    private UnitService unitService;

    private ItemGroupService itemGroupService;

    public ItemController(ItemService itemService, UnitService unitService, ItemGroupService itemGroupService) {
        this.itemService = itemService;
        this.unitService = unitService;
        this.itemGroupService = itemGroupService;
    }

    @GetMapping("/admin/items")
    public String items(Model model){
        List<ItemDto> items = itemService.findAllItems();
        model.addAttribute("items", items);
        return "/admin/items";
    }

    @GetMapping("admin/items/newitem")
    public String newItemForm(Model model){
        ItemDto itemDto = new ItemDto();
        model.addAttribute("item", itemDto);
        List<Unit> units = unitService.findAllUnits();
        model.addAttribute("units", units);
        List<ItemGroup> itemGroups = itemGroupService.findAllItemGroups();
        model.addAttribute("itemGroups", itemGroups);
        return "admin/create_item";
    }

    @PostMapping("/admin/items")
    public String createItem(@ModelAttribute ItemDto itemDto){
        itemService.createItem(itemDto);
        return "redirect:/admin/items";
    }


    @GetMapping("/admin/items/{itemId}/edit")
    public String editItem(@PathVariable("itemId") Long itemId,
                           Model model){
        ItemDto itemDto = itemService.findItemById(itemId);
        model.addAttribute("item", itemDto);
        List<Unit> units = unitService.findAllUnits();
        model.addAttribute("units", units);
        List<ItemGroup> itemGroups = itemGroupService.findAllItemGroups();
        model.addAttribute("itemGroups", itemGroups);
        return "admin/edit_item";
    }


    @PostMapping("admin/items/{itemId}")
    public String updateItem(@PathVariable("itemId") Long itemId,
                             @ModelAttribute("item") ItemDto item,
                             Model model){
        item.setId(itemId);
        itemService.updateItem(item);
        return "redirect:/admin/items";

    }



}
