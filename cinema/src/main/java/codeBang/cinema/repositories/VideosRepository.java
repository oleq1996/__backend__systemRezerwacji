package codeBang.cinema.repositories;

import codeBang.cinema.domain.Videos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideosRepository extends CrudRepository<Videos,Integer> {
}
