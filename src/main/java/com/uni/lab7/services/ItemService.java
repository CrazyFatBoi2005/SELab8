package com.uni.lab7.services;

import com.uni.lab7.dto.ItemDto;
import com.uni.lab7.entities.Item;
import com.uni.lab7.mappers.ItemMapper;
import com.uni.lab7.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemDto> findAll() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.toDtoList(items);
    }

    public ItemDto findById(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item == null) {
            return null;
        }
        return itemMapper.toDto(item);
    }

    public ItemDto create(ItemDto itemDto){

        return itemMapper.toDto(itemRepository.save(itemMapper.toEntity(itemDto)));
    }

    public ItemDto update(Long id, ItemDto itemDto) {
        ItemDto checkItem = findById(id);
        if (Objects.isNull(checkItem)) {
            return null;
        }
        Item item = itemMapper.toEntity(itemDto);
        Item updatedItem = itemRepository.save(item);
        return itemMapper.toDto(updatedItem);
    }

    public boolean deleteById(Long id) {
        ItemDto checkItem = findById(id);
        if (Objects.isNull(checkItem)) {
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }
}
