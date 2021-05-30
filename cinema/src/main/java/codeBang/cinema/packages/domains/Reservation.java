package codeBang.cinema.packages.domains;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String id;
    private String email;
    private Integer playingId;
    private Integer seatId;

    public Reservation(String email, Integer playingId, Integer seatId) {
        this.email = email;
        this.playingId = playingId;
        this.seatId = seatId;
    }

    public Reservation() {

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPlayingId() {
        return playingId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlayingId(Integer playing_id) {
        this.playingId = playing_id;
    }

    public void setSeatId(Integer seat_id) {
        this.seatId = seat_id;
    }
}
