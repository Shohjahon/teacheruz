package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.TRoomLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shoh Jahon on 18.05.2018.
 */
public interface TRoomLessonRepository extends JpaRepository<TRoomLesson,Long> {
    public List<TRoomLesson> findTRoomLessonsByUserId(Long id);
}
