package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.University;
import com.teacher.uz.my.domains.UniversityField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shoh Jahon on 12.04.2018.
 */
public interface UniversityFieldRepository extends JpaRepository<UniversityField, Long> {
    public List<University> getUniversityFieldsByUniversity(University university);
}
