package backend.repository;

import backend.entity.DataBlock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface DataBlockRepository extends CrudRepository<DataBlock, Long> {

    @Query("SELECT db.id, db.blocksize, db.timestamp, db.totalTransactions, db.type1transactions, db.type2transactions, db.type3transactions, db.type4transactions, db.type5transactions, db.type6transactions, db.type7transactions, db.type8transactions, db.type9transactions, db.type10transactions, db.type11transactions, db.type12transactions, db.type13transactions, db.type14transactions FROM DataBlock db WHERE timestamp > :id")
    List<DataBlock> findAllAfter(@Param("id") Timestamp id);

    @Query("SELECT db.id, db.blocksize, db.timestamp, db.totalTransactions, db.type1transactions, db.type2transactions, db.type3transactions, db.type4transactions, db.type5transactions, db.type6transactions, db.type7transactions, db.type8transactions, db.type9transactions, db.type10transactions, db.type11transactions, db.type12transactions, db.type13transactions, db.type14transactions FROM DataBlock db WHERE timestamp < :id")
    List<DataBlock> findAllBefore(@Param("id") Timestamp id);

    @Query("SELECT db.id, db.blocksize, db.timestamp, db.totalTransactions, db.type1transactions, db.type2transactions, db.type3transactions, db.type4transactions, db.type5transactions, db.type6transactions, db.type7transactions, db.type8transactions, db.type9transactions, db.type10transactions, db.type11transactions, db.type12transactions, db.type13transactions, db.type14transactions FROM DataBlock db WHERE id = (SELECT MAX(d.id) FROM DataBlock d )")
    DataBlock findLast();

    @Query("DELETE FROM DataBlock WHERE id = (SELECT MAX(id) FROM DataBlock )")
    void deleteLast();
}
