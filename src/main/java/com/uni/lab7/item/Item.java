package com.uni.lab7.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
}
