package codeBang.cinema.repositories;

import codeBang.cinema.domain.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test,Integer> {
}
