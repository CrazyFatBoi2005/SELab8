package com.uni.lab7.services;

import com.uni.lab7.dto.UserDto;
import com.uni.lab7.entities.User;
import com.uni.lab7.mappers.UserMapper;
import com.uni.lab7.repositories.ItemRepository;
import com.uni.lab7.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ItemRepository itemRepository;

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (Objects.isNull(user)) {
            return null;
        }
        return userMapper.toDto(user);
    }

    public UserDto create(UserDto userDto){
        User user = User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
        if (userDto.getFavoriteItemIds() != null) {
            var items = itemRepository.findAllById(userDto.getFavoriteItemIds());
            user.setFavorites(items);
        }

        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto update(Long id, UserDto userDto) {
        var isUser = userRepository.findById(id);
        if (isUser.isPresent()) {
            User user = isUser.get();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            if (userDto.getFavoriteItemIds() != null) {
                var items = itemRepository.findAllById(userDto.getFavoriteItemIds());
                user.setFavorites(items);
            }
            return userMapper.toDto(userRepository.save(user));
        }
        return null;
    }

    public boolean deleteById(Long id) {
        UserDto checkUser = findById(id);
        if (Objects.isNull(checkUser)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
