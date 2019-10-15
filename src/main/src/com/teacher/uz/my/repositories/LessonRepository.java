package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shoh Jahon on 18.05.2018.
 */
public interface LessonRepository extends JpaRepository<Lesson,Long>{
}
