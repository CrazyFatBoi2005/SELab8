package com.uni.lab7.mappers;

import com.uni.lab7.dto.ItemDto;
import com.uni.lab7.dto.UserDto;
import com.uni.lab7.entities.Item;
import com.uni.lab7.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "favoriteItemIds", source = "favorites")
    UserDto toDto(User user);

    @Mapping(target = "favorites", source = "favoriteItemIds")
    User toEntity(UserDto userDto);

    ItemDto toItemDto(Item item);
    Item toItem(ItemDto itemDto);

    List<UserDto> toDtoList(List<User> users);
    default List<Long> itemsToIds(List<Item> items) {
        if (items == null) return null;
        return items.stream().map(Item::getItem_id).collect(Collectors.toList());
    }

    default List<Item> idsToItems(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> {
            Item item = new Item();
            item.setItem_id(id);
            return item;
        }).collect(Collectors.toList());
    }
}
