package com.uni.lab7.dto;

import com.uni.lab7.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String name;
    private String description;

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getCategory_id())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .category_id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();
    }
}
