package com.uni.lab7.mappers;

import com.uni.lab7.dto.ItemDto;
import com.uni.lab7.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    @Mapping(source = "category.category_id", target = "categoryId")
    ItemDto toDto(Item item);
    @Mapping(source = "categoryId", target = "category.category_id")
    Item toEntity(ItemDto itemDto);

    @Mapping(source = "category.category_id", target = "categoryId")
    List<ItemDto> toDtoList(List<Item> items);
}
