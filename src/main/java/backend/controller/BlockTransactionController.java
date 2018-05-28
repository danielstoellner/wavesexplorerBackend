package backend.controller;

import backend.entity.BlockTransaction;
import backend.repository.BlockTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(path = "/blocktransactions")
public class BlockTransactionController {
    private final BlockTransactionRepository blockTransactionRepository;

    @Autowired
    public BlockTransactionController(BlockTransactionRepository blockTransactionRepository){
        this.blockTransactionRepository = blockTransactionRepository;
    }

    @PostMapping(path="")
    public @ResponseBody boolean addBlockTransaction(@RequestBody BlockTransaction blockTransaction){

        BlockTransaction newBlockTransaction = new BlockTransaction();

        newBlockTransaction.setDate(blockTransaction.getDate());
        newBlockTransaction.setCountBlocks(blockTransaction.getCountBlocks());
        newBlockTransaction.setAvgBlocks(blockTransaction.getAvgBlocks());
        newBlockTransaction.setTotalBlockSize(blockTransaction.getTotalBlockSize());
        newBlockTransaction.setCountTransactions(blockTransaction.getCountTransactions());

        newBlockTransaction.setType_1(blockTransaction.getType_1());
        newBlockTransaction.setType_2(blockTransaction.getType_2());
        newBlockTransaction.setType_3(blockTransaction.getType_3());
        newBlockTransaction.setType_4(blockTransaction.getType_4());
        newBlockTransaction.setType_5(blockTransaction.getType_5());
        newBlockTransaction.setType_6(blockTransaction.getType_6());
        newBlockTransaction.setType_7(blockTransaction.getType_7());
        newBlockTransaction.setType_8(blockTransaction.getType_8());
        newBlockTransaction.setType_9(blockTransaction.getType_9());
        newBlockTransaction.setType_10(blockTransaction.getType_10());
        newBlockTransaction.setType_11(blockTransaction.getType_11());
        newBlockTransaction.setType_12(blockTransaction.getType_12());
        newBlockTransaction.setType_13(blockTransaction.getType_13());
        newBlockTransaction.setType_14(blockTransaction.getType_14());
        newBlockTransaction.setType_15(blockTransaction.getType_15());

        blockTransactionRepository.save(blockTransaction);
        return true;
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteMessageById(@PathVariable(value="id") long id) {
        BlockTransaction blockTransaction = new BlockTransaction();
        blockTransaction = blockTransactionRepository.findOne(id);

        if(blockTransaction != null){
            blockTransactionRepository.delete(blockTransaction);
            return blockTransaction.getDate() + " is deleted";
        }

        return "BlockTransaction cannot deleted!";
    }

    @PutMapping(path="/{id}")
    public @ResponseBody BlockTransaction updateUser (@PathVariable(value="id") long id, @RequestBody BlockTransaction updatedBlockTransaction, Long user){
        BlockTransaction savedBlockTransaction = blockTransactionRepository.findOne(id);

        if (savedBlockTransaction != null){

            savedBlockTransaction.setDate(updatedBlockTransaction.getDate());
            savedBlockTransaction.setCountBlocks(updatedBlockTransaction.getCountBlocks());
            savedBlockTransaction.setAvgBlocks(updatedBlockTransaction.getAvgBlocks());
            savedBlockTransaction.setTotalBlockSize(updatedBlockTransaction.getTotalBlockSize());
            savedBlockTransaction.setCountTransactions(updatedBlockTransaction.getCountTransactions());

            savedBlockTransaction.setType_1(updatedBlockTransaction.getType_1());
            savedBlockTransaction.setType_2(updatedBlockTransaction.getType_2());
            savedBlockTransaction.setType_3(updatedBlockTransaction.getType_3());
            savedBlockTransaction.setType_4(updatedBlockTransaction.getType_4());
            savedBlockTransaction.setType_5(updatedBlockTransaction.getType_5());
            savedBlockTransaction.setType_6(updatedBlockTransaction.getType_6());
            savedBlockTransaction.setType_7(updatedBlockTransaction.getType_7());
            savedBlockTransaction.setType_8(updatedBlockTransaction.getType_8());
            savedBlockTransaction.setType_9(updatedBlockTransaction.getType_9());
            savedBlockTransaction.setType_10(updatedBlockTransaction.getType_10());
            savedBlockTransaction.setType_11(updatedBlockTransaction.getType_11());
            savedBlockTransaction.setType_12(updatedBlockTransaction.getType_12());
            savedBlockTransaction.setType_13(updatedBlockTransaction.getType_13());
            savedBlockTransaction.setType_14(updatedBlockTransaction.getType_14());
            savedBlockTransaction.setType_15(updatedBlockTransaction.getType_15());


            blockTransactionRepository.save(savedBlockTransaction);
            return savedBlockTransaction;
        } else {
            return null;
        }
    }

    @GetMapping(path="")
    public @ResponseBody Iterable<BlockTransaction> getAllUsers() {
        // This returns a JSON or XML with the users
        return blockTransactionRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    BlockTransaction getParameterDetails (@PathVariable(value="id") long id) {
        return blockTransactionRepository.findOne(id);
    }


}
