package codeBang.cinema.packages.services;

import codeBang.cinema.packages.domains.Seat;
import codeBang.cinema.packages.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAllSeatData(){
        List<Seat> allSeatData = new ArrayList<>();
        seatRepository.findAll().forEach(allSeatData::add);
        return allSeatData;
    }

}
