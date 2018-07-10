import backend.entity.DataBlock;
import backend.repository.DataBlockRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class DataBlockRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DataBlockRepository dataBlockRepository;


    @Test
    public void findAllAfter() {
        //given
        DataBlock firstBlock = new DataBlock();
        firstBlock.setTimestamp(Timestamp.valueOf("2016-06-12 21:22:13.283"));

        DataBlock secondBlock = new DataBlock();
        secondBlock.setTimestamp(Timestamp.valueOf("2016-06-13 05:25:07.773"));
        secondBlock.setId(8);

        //when
        List<DataBlock> blocks = dataBlockRepository.findAllAfter(secondBlock.getTimestamp());

        //then
        assertThat(blocks.size()).isEqualTo((int)(dataBlockRepository.count()-secondBlock.getId()));

    }

    @Test
    public void findAllBefore() {
        //given
        DataBlock firstBlock = new DataBlock();
        firstBlock.setTimestamp(Timestamp.valueOf("2016-06-12 21:22:13.283"));

        //when
        List<DataBlock> blocks = dataBlockRepository.findAllBefore(firstBlock.getTimestamp());

        //then
        assertThat(blocks.size()).isEqualTo(2);
    }

//    @Test
//    public void findLast() {
//        //when
//        DataBlock block = dataBlockRepository.findLast();
//
//        //then
//        assertThat(block.getId()).isEqualTo(dataBlockRepository.count());
//    }
//
//    @Test
//    public void deleteAndReInsertLast() {
//        //given
//        DataBlock firstBlock = new DataBlock();
//        firstBlock.setTimestamp(Timestamp.valueOf("2016-06-12 21:22:13.283"));
//
//        //when
//        List<DataBlock> blocks = dataBlockRepository.findAllBefore(firstBlock.getTimestamp());
//
//        //then
//        assertThat(blocks.size()).isEqualTo(2);
//    }
}