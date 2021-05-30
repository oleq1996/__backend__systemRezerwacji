package codeBang.cinema.packages.repositories;

import codeBang.cinema.packages.domains.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query("SELECT r FROM Reservation r WHERE r.playingId = ?1")
    List<Reservation> getReservationData(Integer playingId);
}
