package codeBang.cinema.testApi.services;

import codeBang.cinema.testApi.domains.Seat;
import codeBang.cinema.testApi.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeatData(){
        List<Seat> allSeatData = new ArrayList<>();
        seatRepository.findAll().forEach(allSeatData::add);
        return allSeatData;
    }
}
