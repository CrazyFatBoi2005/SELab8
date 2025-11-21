package com.uni.lab7.controllers;

import com.uni.lab7.dto.ItemDto;
import com.uni.lab7.dto.UserDto;
import com.uni.lab7.entities.Item;
import com.uni.lab7.services.FavoriteService;
import com.uni.lab7.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FavoriteService favoriteService;

    @GetMapping("/")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/")
    public UserDto save(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PatchMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/{id}/favorites")
    public List<ItemDto> getFavoritesById(@PathVariable Long id) {
        return favoriteService.getFavoriteItems(id);
    }
}
