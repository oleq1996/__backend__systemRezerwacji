package codeBang.cinema.packages.repositories;

import codeBang.cinema.packages.domains.Playing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PlayingRepository extends JpaRepository<Playing,Integer> {

    @Query("SELECT p FROM Playing p WHERE p.date = ?1")
    List<Playing> getPlayingData(Date date);

}
