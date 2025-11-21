package com.uni.lab7.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteItemDto {
    private Long item_id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
}
