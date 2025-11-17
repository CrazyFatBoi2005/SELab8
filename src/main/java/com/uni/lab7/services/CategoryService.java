package com.uni.lab7.services;

import com.uni.lab7.dto.CategoryDto;
import com.uni.lab7.entities.Category;
import com.uni.lab7.mappers.CategoryMapper;
import com.uni.lab7.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public List<CategoryDto> findAll() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return null;
        }
        return categoryMapper.toDto(category);
    }

    public CategoryDto create(CategoryDto categoryDto) {
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(categoryDto)));
    }

    public CategoryDto update(Long id, CategoryDto categoryDto) {
        CategoryDto checkCategoty = findById(id);
        if (Objects.isNull(checkCategoty)) {
            return null;
        }
        Category category = categoryMapper.toEntity(categoryDto);
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(updatedCategory);
    }

    public boolean deleteById(Long id) {
        CategoryDto checkCategory = findById(id);
        if (Objects.isNull(checkCategory)) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }
}
