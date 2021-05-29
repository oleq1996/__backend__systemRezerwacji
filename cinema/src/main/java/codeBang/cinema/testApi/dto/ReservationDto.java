package codeBang.cinema.testApi.dto;

public class ReservationDto {

    private String email;
    private Integer playing_id;
    private Integer seat_id;

    public ReservationDto(String email, Integer playing_id, Integer seat_id) {
        this.email = email;
        this.playing_id = playing_id;
        this.seat_id = seat_id;
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
}
