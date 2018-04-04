package backend.repository;

import backend.entity.Squad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Squad, Long> {

}
