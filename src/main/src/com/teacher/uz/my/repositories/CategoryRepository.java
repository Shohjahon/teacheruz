package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
