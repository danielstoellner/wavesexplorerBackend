package backend.controller;

import backend.entity.BlockData;
import backend.entity.DataBlock;
import backend.entity.Height;
import backend.repository.DataBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class StatisticsControllerImpl implements StatisticsController {

    private Logger log = Logger.getLogger(StatisticsControllerImpl.class.getName());

    @Autowired
    private DataBlockRepository dbRep;

    private RestTemplate restTemplate;
    private HttpEntity<String> entity;

    private void createRestTemplate(){

        restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        entity = new HttpEntity<>("parameters", headers);
    }

    @Override
    public List<DataBlock> getAll(){

        // Not really a clean solution but it does what it is supposed to do
        // When using dbRep.findAll() the data is returned as JSON Object instead of a JSON Array
        Timestamp now = new Timestamp(new Date().getTime());

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(now.getTime());

        now = new Timestamp(cal.getTime().getTime());

        return dbRep.findAllBefore(now);
    }

    @Override
    public void refreshData() {

        createRestTemplate();

        log.info("refreshStatistics");

        int getAmount = 99;

        ResponseEntity<Height> resp = restTemplate.exchange("http://nodes.wavesplatform.com/blocks/height",HttpMethod.GET, entity, Height.class);
        long currentMax = resp.getBody().getHeight();

        long maxPersistentBlocks = dbRep.count()*getAmount;

        log.info("start loading");

        if(currentMax - maxPersistentBlocks > 100){
            for (long i = maxPersistentBlocks+1; i < currentMax-getAmount; i = i + getAmount) {
                long help = (i + getAmount -1);
                ResponseEntity<BlockData[]> response = restTemplate.exchange("http://nodes.wavesnodes.com/blocks/seq/" + i + "/" + help, HttpMethod.GET, entity, BlockData[].class);

                Timestamp timestamp;
                int transactionCount = 0;
                int blockSize = 0;
                int[] transPType = new int[14];

                for (int j = 0; j < response.getBody().length; j++) {
                    transactionCount = transactionCount + response.getBody()[j].getTransactionCount();
                    blockSize = blockSize + response.getBody()[j].getBlocksize();
                    if(response.getBody()[j].getTransactions() != null) {
                        for (int k = 0; k < response.getBody()[j].getTransactions().length; k++) {
                            transPType[response.getBody()[j].getTransactions()[k].getType() - 1]++;
                        }
                    }
                }

                Date date = new Date(response.getBody()[0].getTimestamp());

                timestamp = new Timestamp(date.getTime());


                log.info("persist header "+i+" - "+help);

                DataBlock data = new DataBlock();

                data.setBlocksize(blockSize);
                data.setTimestamp(timestamp);
                data.setTotalTransactions(transactionCount);

                data.setType1transactions(transPType[0]);
                data.setType2transactions(transPType[1]);
                data.setType3transactions(transPType[2]);
                data.setType4transactions(transPType[3]);
                data.setType5transactions(transPType[4]);
                data.setType6transactions(transPType[5]);
                data.setType7transactions(transPType[6]);
                data.setType8transactions(transPType[7]);
                data.setType9transactions(transPType[8]);
                data.setType10transactions(transPType[9]);
                data.setType11transactions(transPType[10]);
                data.setType12transactions(transPType[11]);
                data.setType13transactions(transPType[12]);
                data.setType14transactions(transPType[13]);

                dbRep.save(data);
            }
        }
        else{
            log.info("else branch -> delete last row and update with current values");
            ResponseEntity<BlockData[]> response = restTemplate.exchange("http://nodes.wavesnodes.com/blocks/seq/" + (maxPersistentBlocks-getAmount) + "/" + currentMax, HttpMethod.GET, entity, BlockData[].class);

            Timestamp timestamp;
            int transactionCount = 0;
            int blockSize = 0;
            int[] transPType = new int[14];

            for (int j = 0; j < response.getBody().length; j++) {
                transactionCount = transactionCount + response.getBody()[j].getTransactionCount();
                blockSize = blockSize + response.getBody()[j].getBlocksize();
                if(response.getBody()[j].getTransactions() != null) {
                    for (int k = 0; k < response.getBody()[j].getTransactions().length; k++) {
                        transPType[response.getBody()[j].getTransactions()[k].getType() - 1]++;
                    }
                }
            }

            Date date = new Date(response.getBody()[0].getTimestamp());

            timestamp = new Timestamp(date.getTime());

            DataBlock data = dbRep.findLast();

            data.setBlocksize(blockSize);
            data.setTimestamp(timestamp);
            data.setTotalTransactions(transactionCount);

            data.setType1transactions(transPType[0]);
            data.setType2transactions(transPType[1]);
            data.setType3transactions(transPType[2]);
            data.setType4transactions(transPType[3]);
            data.setType5transactions(transPType[4]);
            data.setType6transactions(transPType[5]);
            data.setType7transactions(transPType[6]);
            data.setType8transactions(transPType[7]);
            data.setType9transactions(transPType[8]);
            data.setType10transactions(transPType[9]);
            data.setType11transactions(transPType[10]);
            data.setType12transactions(transPType[11]);
            data.setType13transactions(transPType[12]);
            data.setType14transactions(transPType[13]);

            dbRep.deleteLast();
            dbRep.save(data);
        }

        log.info("finished loading");
    }


    @Override
    public List<DataBlock> getYear() {
        return dbRep.findAllAfter(getTs(Calendar.DAY_OF_MONTH, -365));
    }

    @Override
    public List<DataBlock> getMonth() {
        return dbRep.findAllAfter(getTs(Calendar.DAY_OF_MONTH, -30));
    }

    @Override
    public List<DataBlock> getWeek() {

        return dbRep.findAllAfter(getTs(Calendar.DAY_OF_MONTH, -7));
    }

    @Override
    public List<DataBlock> getDay() {

        Timestamp now = new Timestamp(new Date().getTime());

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(now.getTime());

        cal.add(Calendar.DAY_OF_MONTH, -1);
        now = new Timestamp(cal.getTime().getTime());

        return dbRep.findAllAfter(now);
    }

    private Timestamp getTs(int calendar, int amount){
        Timestamp now = new Timestamp(new Date().getTime());

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(now.getTime());

        cal.add(calendar, amount);
        now = new Timestamp(cal.getTime().getTime());

        return now;
    }
}
