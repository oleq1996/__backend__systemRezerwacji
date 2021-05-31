package codeBang.cinema.packages.services;

import codeBang.cinema.packages.domains.Playing;
import codeBang.cinema.packages.dto.PlayingDto;
import codeBang.cinema.packages.dto.SeatDto;
import codeBang.cinema.packages.repositories.PlayingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayingService {

    @Autowired
   private PlayingRepository playingRepository;

    public List<PlayingDto> getAllPlayingData(){
        List<Playing> allPlayingData = new ArrayList<>();
        List<PlayingDto> allPlayingDataDto = new ArrayList<>();

        playingRepository.findAll().forEach(allPlayingData::add);

        for(Playing playing : allPlayingData){
            allPlayingDataDto.add(new PlayingDto(playing));
        }

        return allPlayingDataDto;
    }

    public List<PlayingDto> getPlayingData(String date){
        List<Playing> allPlayingData = new ArrayList<>();
        List<PlayingDto> allPlayingDataDto = new ArrayList<>();

        allPlayingData = playingRepository.getPlayingData(Date.valueOf(date));
        for(Playing playing : allPlayingData){
            allPlayingDataDto.add(new PlayingDto(playing));
        }
        return allPlayingDataDto;
    }
}
