package codeBang.cinema.testApi.repositories;

import codeBang.cinema.testApi.domains.Premiere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiereRepository extends CrudRepository<Premiere,Integer> {
}
