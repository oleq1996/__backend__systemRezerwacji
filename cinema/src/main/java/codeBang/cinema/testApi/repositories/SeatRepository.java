package codeBang.cinema.testApi.repositories;

import codeBang.cinema.testApi.domains.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends CrudRepository<Seat,Integer> {
}
