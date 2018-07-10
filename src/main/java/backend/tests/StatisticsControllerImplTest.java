import backend.controller.StatisticsController;
import backend.entity.DataBlock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(StatisticsController.class)
public class StatisticsControllerImplTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StatisticsController statCtrl;

    private DataBlock block;

    @Before
    public void init() {
        block = new DataBlock();
        block.setBlocksize(23243);
    }

    @Test
    public void getYear() throws Exception{

        List<DataBlock> allBlocks = Collections.singletonList(block);

        given(statCtrl.getYear()).willReturn(allBlocks);

        mvc.perform(get("/statistics/getYear")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getMonth() throws Exception{

        List<DataBlock> allBlocks = Collections.singletonList(block);

        given(statCtrl.getMonth()).willReturn(allBlocks);

        mvc.perform(get("/statistics/getMonth")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getWeek() throws Exception{
        List<DataBlock> allBlocks = Collections.singletonList(block);

        given(statCtrl.getWeek()).willReturn(allBlocks);

        mvc.perform(get("/statistics/getWeek")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}