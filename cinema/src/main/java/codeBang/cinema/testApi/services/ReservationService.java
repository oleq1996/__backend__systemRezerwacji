package codeBang.cinema.testApi.services;

import codeBang.cinema.testApi.domains.Reservation;
import codeBang.cinema.testApi.dto.ReservationDto;
import codeBang.cinema.testApi.dto.SeatDto;
import codeBang.cinema.testApi.mapper.ReservationMapper;
import codeBang.cinema.testApi.mapper.SeatMapper;
import codeBang.cinema.testApi.repositories.ReservationRepository;
import codeBang.cinema.testApi.repositories.SeatRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;

    public ReservationService(ReservationRepository reservationRepository, SeatRepository seatRepository) {
        this.reservationRepository = reservationRepository;
        this.seatRepository = seatRepository;

    }

    public List<Reservation> getAllReservationData(){
        List<Reservation> allReservationData = new ArrayList<>();
        reservationRepository.findAll().forEach(allReservationData::add);
        return allReservationData;
    }

    public List<Reservation> postNewReservationList(List<ReservationDto> reservationDtoList){
        List<Reservation> reservationList = new ArrayList();
        boolean exist = false;

        ExampleMatcher reservationMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id","email")
                .withMatcher("playing_id", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("seat_id",ExampleMatcher.GenericPropertyMatchers.exact());

        for (ReservationDto reservationDto: reservationDtoList){

            Reservation reservation = ReservationMapper.parseToEntity(reservationDto);
            Example<Reservation> example = Example.of(reservation,reservationMatcher);

            if(exist = reservationRepository.exists(example)){
                break;
            }
            reservationList.add(reservation);

        }

        if(!exist) {
            return reservationRepository.saveAll(reservationList);
        }
        return null;
    }

    public String getReservationMail(List<ReservationDto> reservations){
        String mail = reservations.get(0).getEmail();
        return mail;
    }

    public List<SeatDto> getReservedSeats(List<Reservation> reservations){
        List<SeatDto> reservedSeats = new ArrayList<>();
        for(Reservation reservation : reservations){
            reservedSeats.add(SeatMapper.parseToDto(seatRepository.findById(reservation.getSeatId())));
        }
        return reservedSeats;
    }

    public List<SeatDto> getAllReservedSeats(Integer playingId){
        List<Reservation> reservations = reservationRepository.getReservationData(playingId);
        List<SeatDto> reservedSeats = new ArrayList<>();
        for(Reservation reservation : reservations){
            reservedSeats.add(SeatMapper.parseToDto(seatRepository.findById(reservation.getSeatId())));
        }
        return reservedSeats;
    }

}
