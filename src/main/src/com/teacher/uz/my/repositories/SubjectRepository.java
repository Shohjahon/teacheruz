package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
