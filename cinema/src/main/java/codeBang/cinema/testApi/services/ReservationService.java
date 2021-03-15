package codeBang.cinema.testApi.services;

import codeBang.cinema.testApi.domains.Reservation;
import codeBang.cinema.testApi.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservationData(){
        List<Reservation> allReservationData = new ArrayList<>();
        reservationRepository.findAll().forEach(allReservationData::add);
        return allReservationData;
    }
    public Iterable<Reservation> putNewReservationList(List<Reservation> reservationList){
        return reservationRepository.saveAll(reservationList);
    }
}
