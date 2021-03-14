package codeBang.cinema.services;

import codeBang.cinema.domain.Videos;
import codeBang.cinema.repositories.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideosService {

    @Autowired
    private VideosRepository videosRepository;

    public List<Videos> getAllTestData(){
        List<Videos> allVideosData = new ArrayList<>();
        videosRepository.findAll().forEach(allVideosData::add);
        return allVideosData;
    }
}
