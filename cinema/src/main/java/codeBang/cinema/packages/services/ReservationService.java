package codeBang.cinema.packages.services;

import codeBang.cinema.packages.domains.Reservation;
import codeBang.cinema.packages.dto.ReservationDto;
import codeBang.cinema.packages.dto.SeatDto;
import codeBang.cinema.packages.mapper.ReservationMapper;
import codeBang.cinema.packages.mapper.SeatMapper;
import codeBang.cinema.packages.repositories.ReservationRepository;
import codeBang.cinema.packages.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private SeatRepository seatRepository;

    public List<ReservationDto> getAllReservationData(){
        List<Reservation> allReservationData = new ArrayList<>();
        List<ReservationDto> allReservationDataDto = new ArrayList<>();

        reservationRepository.findAll().forEach(allReservationData::add);
        for(Reservation reservation : allReservationData){
            allReservationDataDto.add(new ReservationDto(reservation));
        }
        return allReservationDataDto;
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
