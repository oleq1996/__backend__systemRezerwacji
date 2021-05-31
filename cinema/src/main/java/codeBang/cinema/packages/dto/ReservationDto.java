package codeBang.cinema.packages.dto;

import codeBang.cinema.packages.domains.Reservation;

public class ReservationDto {

    private String email;
    private Integer playing_id;
    private Integer seat_id;

    public ReservationDto(String email, Integer playing_id, Integer seat_id) {
        this.email = email;
        this.playing_id = playing_id;
        this.seat_id = seat_id;
    }

    public ReservationDto(Reservation reservation) {
        this.email = reservation.getEmail();
        this.playing_id = reservation.getPlayingId();
        this.seat_id = reservation.getSeatId();
    }

    public String getEmail() {
        return email;
    }

    public Integer getPlaying_id() {
        return playing_id;
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlaying_id(Integer playing_id) {
        this.playing_id = playing_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }
}
