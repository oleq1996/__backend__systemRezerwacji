package codeBang.cinema.packages.repositories;

import codeBang.cinema.packages.domains.Reservation;
import codeBang.cinema.packages.domains.Video;
import codeBang.cinema.packages.dto.VideoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {

    @Query("SELECT v FROM Video v WHERE v.id = ?1")
    Video getVideoData(Integer videoId);
}
