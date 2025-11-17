package com.uni.lab7.dto;

import com.uni.lab7.entities.Item;
import com.uni.lab7.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long user_id;
    private String username;
    private String password;
    private List<Long> favoriteItemIds;

    public static UserDto toDto(User user) {
        List<Long> favoriteIds = user.getFavorites().stream()
                .map(Item::getItem_id)
                .toList();

        return UserDto.builder()
                .user_id(user.getUser_id())
                .username(user.getUsername())
                .password(user.getPassword())
                .favoriteItemIds(favoriteIds)
                .build();
    }
}
