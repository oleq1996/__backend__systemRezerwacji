package codeBang.cinema.testApi.repositories;

import codeBang.cinema.testApi.domains.Reservation;
import codeBang.cinema.testApi.dto.SeatDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query("SELECT r FROM Reservation r WHERE r.playing_id = ?1")
    List<Reservation> getReservationData(Integer playingId);
}
