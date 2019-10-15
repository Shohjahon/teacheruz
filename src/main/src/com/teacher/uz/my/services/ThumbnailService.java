package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.Thumbnail;
import com.teacher.uz.my.repositories.ThumbnailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class ThumbnailService {
    @Autowired
    private ThumbnailRepository thumbnailRepository;

    public List<Thumbnail> getAllThumbnails(){
        return thumbnailRepository.findAll();
    }
    public Thumbnail getThumbnail(int id){
        return thumbnailRepository.findOne(Long.valueOf(id));
    }
    public void saveThumbnail(Thumbnail thumbnail){
        thumbnailRepository.save(thumbnail);
    }
    public void deleteThumbnail(int id){
        thumbnailRepository.delete(Long.valueOf(id));
    }
    public List<Thumbnail> getThumbnailsByArticle(int id){
        return thumbnailRepository.findThumbnailByArticleId(Long.valueOf(id));
    }
}
