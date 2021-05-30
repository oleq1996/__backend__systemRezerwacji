package codeBang.cinema.packages.repositories;

import codeBang.cinema.packages.domains.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {

}
