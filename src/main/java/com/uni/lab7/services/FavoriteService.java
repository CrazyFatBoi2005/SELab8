package com.uni.lab7.services;

import com.uni.lab7.dto.ItemDto;
import com.uni.lab7.entities.Item;
import com.uni.lab7.entities.User;
import com.uni.lab7.mappers.ItemMapper;
import com.uni.lab7.repositories.ItemRepository;
import com.uni.lab7.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemDto> getFavoriteItems(Long userId) {
        Optional<User> userCheck = userRepository.findById(userId);
        if (userCheck.isPresent()) {
            User user = userCheck.get();
            return itemMapper.toDtoList(user.getFavorites());
        }
        return null;
    }
}
