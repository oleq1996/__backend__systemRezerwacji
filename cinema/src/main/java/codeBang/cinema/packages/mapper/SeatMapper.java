package codeBang.cinema.packages.mapper;

import codeBang.cinema.packages.domains.Seat;
import codeBang.cinema.packages.dto.SeatDto;

import java.util.Optional;

public class SeatMapper {

    public static SeatDto parseToDto(Optional<Seat> seat) {
        if(seat.isPresent()){
            return new SeatDto(seat.get().getId(),seat.get().getRow(),seat.get().getNumber(),seat.get().getSection());
        }
        return null;
    }
}
