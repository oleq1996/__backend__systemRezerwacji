package codeBang.cinema.packages.mapper;

import codeBang.cinema.packages.domains.Playing;
import codeBang.cinema.packages.domains.Reservation;
import codeBang.cinema.packages.dto.PlayingDto;
import codeBang.cinema.packages.dto.ReservationDto;

import java.sql.Date;
import java.sql.Time;

public class PlayingMapper {

    public static PlayingDto parseToDto(Playing playing) {
        return new PlayingDto(playing.getId(),
                playing.getVideoId(),
                playing.getDate().toString(),
                playing.getTime().toString());
    }

    public static Playing parseToEntity(PlayingDto playingDto){
        return new Playing(playingDto.getId(),
                playingDto.getVideoId(),
                Date.valueOf(playingDto.getDate()),
                Time.valueOf(playingDto.getTime()));
    }

}
