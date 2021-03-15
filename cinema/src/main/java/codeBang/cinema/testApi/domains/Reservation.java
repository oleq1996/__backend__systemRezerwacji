package codeBang.cinema.testApi.domains;

import javax.persistence.*;

@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private Integer playing_id;
    private Integer seat_id;

    public Reservation(Integer id, String email, Integer playing_id, Integer seat_id) {
        this.id = id;
        this.email = email;
        this.playing_id = playing_id;
        this.seat_id = seat_id;
    }

    public Reservation() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPlaying_id() {
        return playing_id;
    }

    public void setPlaying_id(Integer playing_id) {
        this.playing_id = playing_id;
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }
}
