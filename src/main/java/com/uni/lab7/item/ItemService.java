package com.uni.lab7.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemDto> findAll() {
        return itemRepository.findAll().stream().map(ItemDto::toDto).collect(Collectors.toList());
    }

    public ItemDto findById(Long id) {
        return itemRepository.findById(id).map(ItemDto::toDto).orElse(null);
    }

    public ItemDto create(ItemDto itemDto){
        return ItemDto.toDto(itemRepository.save(ItemDto.toEntity(itemDto)));
    }

    public ItemDto update(Long id, ItemDto itemDto) {
        Optional<Item> isItem = itemRepository.findById(id);
        if (isItem.isPresent()) {
            Item item = isItem.get();
            item.setName(itemDto.getName());
            item.setDescription(itemDto.getDescription());
            item.setImageUrl(itemDto.getImageUrl());
            item.setPrice(itemDto.getPrice());
            return ItemDto.toDto(itemRepository.save(item));
        }
        return null;
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}
