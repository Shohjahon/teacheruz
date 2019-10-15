package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.Thumbnail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
public interface ThumbnailRepository extends JpaRepository<Thumbnail,Long> {
    public List<Thumbnail> findThumbnailByArticleId(Long id);
}
