package codeBang.cinema.packages.repositories;

import codeBang.cinema.packages.domains.Playing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayingRepository extends JpaRepository<Playing,Integer> {
}
