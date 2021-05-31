package codeBang.cinema.packages.services;

import codeBang.cinema.packages.domains.Video;
import codeBang.cinema.packages.dto.VideoDto;
import codeBang.cinema.packages.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<VideoDto> getAllVideoData(){
        List<Video> allVideoData = new ArrayList<>();
        List<VideoDto> allVideoDataDto = new ArrayList<>();

        videoRepository.findAll().forEach(allVideoData::add);

        for(Video video : allVideoData){
            allVideoDataDto.add(new VideoDto(video));
        }
        return allVideoDataDto;
    }

    public VideoDto getVideoData(Integer videoId){
        return new VideoDto(videoRepository.getVideoData(videoId));
    }
}
