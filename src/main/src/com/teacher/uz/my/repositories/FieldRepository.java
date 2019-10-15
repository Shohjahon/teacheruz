package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.Field;
import com.teacher.uz.my.domains.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shoh Jahon on 12.04.2018.
 */
public interface FieldRepository extends JpaRepository<Field, Long> {
}
