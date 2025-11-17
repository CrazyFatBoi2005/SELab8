package com.uni.lab7.controllers;

import com.uni.lab7.dto.CategoryDto;
import com.uni.lab7.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable Long id) {
        return categoryService.findById(id);
    }
    @PostMapping("/")
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }
    @PatchMapping("/{id}")
    public CategoryDto update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return categoryService.update(id, categoryDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
