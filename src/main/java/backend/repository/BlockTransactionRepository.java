package backend.repository;

import backend.entity.BlockTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockTransactionRepository extends CrudRepository<BlockTransaction, Long> {

}
