package codeBang.cinema.testApi.services;

import codeBang.cinema.testApi.domains.Video;
import codeBang.cinema.testApi.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideoData(){
        List<Video> allVideoData = new ArrayList<>();
        videoRepository.findAll().forEach(allVideoData::add);
        return allVideoData;
    }
}
