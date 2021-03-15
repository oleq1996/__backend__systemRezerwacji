package codeBang.cinema.testApi.repositories;

import codeBang.cinema.testApi.domains.Top;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopRepository extends CrudRepository<Top,Integer> {
}
