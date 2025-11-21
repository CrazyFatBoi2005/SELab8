package com.uni.lab7.services;

import com.uni.lab7.entities.Item;
import com.uni.lab7.entities.User;
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

    public List<Item> getFavoriteItems(Long userId) {
        Optional<User> userCheck = userRepository.findById(userId);
        if (userCheck.isPresent()) {
            User user = userCheck.get();
            return user.getFavorites();
        }
        return null;
    }
}
