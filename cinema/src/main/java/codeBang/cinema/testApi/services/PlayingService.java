package codeBang.cinema.testApi.services;

import codeBang.cinema.testApi.domains.Playing;
import codeBang.cinema.testApi.repositories.PlayingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayingService {

    @Autowired
    PlayingRepository playingRepository;

    public List<Playing> getAllPlayingData(){
        List<Playing> allPlayingData = new ArrayList<>();
        playingRepository.findAll().forEach(allPlayingData::add);
        return allPlayingData;
    }
}
