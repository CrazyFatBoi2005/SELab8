package com.uni.lab7.controllers;

import com.uni.lab7.dto.ItemDto;
import com.uni.lab7.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/")
    public List<ItemDto> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ItemDto getById(@PathVariable Long id) {
        return itemService.findById(id);
    }
    @PostMapping("/")
    public ItemDto create(@RequestBody ItemDto itemDto) {
        return itemService.create(itemDto);
    }
    @PatchMapping("/{id}")
    public ItemDto update(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return itemService.update(id, itemDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}