package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.UniversityField;
import com.teacher.uz.my.domains.UniversityFieldUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shoh Jahon on 20.04.2018.
 */
public interface UniversityFieldUserRepository extends JpaRepository<UniversityFieldUser,Long> {
    public UniversityFieldUser findUniversityFieldUserByUserId(Long id);
}
