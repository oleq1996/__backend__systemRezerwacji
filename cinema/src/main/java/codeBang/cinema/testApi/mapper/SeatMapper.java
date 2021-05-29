package codeBang.cinema.testApi.mapper;

import codeBang.cinema.testApi.domains.Reservation;
import codeBang.cinema.testApi.domains.Seat;
import codeBang.cinema.testApi.dto.ReservationDto;
import codeBang.cinema.testApi.dto.SeatDto;

import java.util.Optional;

public class SeatMapper {

    public static SeatDto parseToDto(Optional<Seat> seat) {
        if(seat.isPresent()){
            return new SeatDto(seat.get().getId(),seat.get().getRow(),seat.get().getNumber(),seat.get().getSection());
        }
        return null;
    }
}
