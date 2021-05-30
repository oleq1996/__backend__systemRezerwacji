package codeBang.cinema.testApi.mapper;

import codeBang.cinema.testApi.domains.Reservation;
import codeBang.cinema.testApi.dto.ReservationDto;

public class ReservationMapper {

    public static ReservationDto parseToDto(Reservation reservation) {
            return new ReservationDto(reservation.getEmail(),
                    reservation.getPlayingId(),
                    reservation.getSeatId());
    }

    public static Reservation parseToEntity(ReservationDto reservationDto){
        return new Reservation(reservationDto.getEmail(),
                reservationDto.getPlaying_id(),
                reservationDto.getSeat_id());
    }
}
