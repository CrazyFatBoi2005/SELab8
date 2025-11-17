package com.uni.lab7.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long item_id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;

    public static ItemDto toDto(Item item) {
        return ItemDto.builder()
                .item_id(item.getItem_id())
                .name(item.getName())
                .description(item.getDescription())
                .imageUrl(item.getImageUrl())
                .price(item.getPrice())
                .build();
    }

    public static Item toEntity(ItemDto item) {
        return Item.builder()
                .item_id(item.getItem_id())
                .description(item.getDescription())
                .name(item.getName())
                .imageUrl(item.getImageUrl())
                .price(item.getPrice())
                .build();
    }
}
