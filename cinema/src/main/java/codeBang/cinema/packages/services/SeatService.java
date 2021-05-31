package codeBang.cinema.packages.services;

import codeBang.cinema.packages.domains.Seat;
import codeBang.cinema.packages.dto.SeatDto;
import codeBang.cinema.packages.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<SeatDto> getAllSeatData(){
        List<Seat> allSeatData = new ArrayList<>();
        List<SeatDto> allSeatDataDto = new ArrayList<>();

        seatRepository.findAll().forEach(allSeatData::add);

        for(Seat seat : allSeatData){
            allSeatDataDto.add(new SeatDto(seat));
        }
        return allSeatDataDto;
    }

}
