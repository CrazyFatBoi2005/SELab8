package com.uni.lab7.repositories;

import com.uni.lab7.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
}
