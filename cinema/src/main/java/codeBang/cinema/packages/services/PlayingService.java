package codeBang.cinema.packages.services;

import codeBang.cinema.packages.domains.Playing;
import codeBang.cinema.packages.repositories.PlayingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayingService {

    @Autowired
   private PlayingRepository playingRepository;

    public List<Playing> getAllPlayingData(){
        List<Playing> allPlayingData = new ArrayList<>();
        playingRepository.findAll().forEach(allPlayingData::add);
        return allPlayingData;
    }
}
