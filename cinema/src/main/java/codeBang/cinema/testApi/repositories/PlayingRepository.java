package codeBang.cinema.testApi.repositories;

import codeBang.cinema.testApi.domains.Playing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayingRepository extends JpaRepository<Playing,Integer> {
}
