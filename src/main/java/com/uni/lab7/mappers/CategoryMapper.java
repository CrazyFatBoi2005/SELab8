package com.uni.lab7.mappers;

import com.uni.lab7.dto.CategoryDto;
import com.uni.lab7.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "category_id", target = "id")
    CategoryDto toDto(Category category);
    @Mapping(source = "id", target = "category_id")
    Category toEntity(CategoryDto categoryDto);
    List<CategoryDto> toDtoList(List<Category> categories);
}
