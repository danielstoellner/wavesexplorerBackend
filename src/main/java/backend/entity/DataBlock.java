package backend.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DataBlock")
public class DataBlock {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private Timestamp timestamp;
    private int type1transactions;
    private int type2transactions;
    private int type3transactions;
    private int type4transactions;
    private int type5transactions;
    private int type6transactions;
    private int type7transactions;
    private int type8transactions;
    private int type9transactions;
    private int type10transactions;
    private int type11transactions;
    private int type12transactions;
    private int type13transactions;
    private int type14transactions;
    private int blocksize;
    private int totalTransactions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getType1transactions() {
        return type1transactions;
    }

    public void setType1transactions(int type1transactions) {
        this.type1transactions = type1transactions;
    }

    public int getType2transactions() {
        return type2transactions;
    }

    public void setType2transactions(int type2transactions) {
        this.type2transactions = type2transactions;
    }

    public int getType3transactions() {
        return type3transactions;
    }

    public void setType3transactions(int type3transactions) {
        this.type3transactions = type3transactions;
    }

    public int getType4transactions() {
        return type4transactions;
    }

    public void setType4transactions(int type4transactions) {
        this.type4transactions = type4transactions;
    }

    public int getType5transactions() {
        return type5transactions;
    }

    public void setType5transactions(int type5transactions) {
        this.type5transactions = type5transactions;
    }

    public int getType6transactions() {
        return type6transactions;
    }

    public void setType6transactions(int type6transactions) {
        this.type6transactions = type6transactions;
    }

    public int getType7transactions() {
        return type7transactions;
    }

    public void setType7transactions(int type7transactions) {
        this.type7transactions = type7transactions;
    }

    public int getType8transactions() {
        return type8transactions;
    }

    public void setType8transactions(int type8transactions) {
        this.type8transactions = type8transactions;
    }

    public int getType9transactions() {
        return type9transactions;
    }

    public void setType9transactions(int type9transactions) {
        this.type9transactions = type9transactions;
    }

    public int getType10transactions() {
        return type10transactions;
    }

    public void setType10transactions(int type10transactions) {
        this.type10transactions = type10transactions;
    }

    public int getType11transactions() {
        return type11transactions;
    }

    public void setType11transactions(int type11transactions) {
        this.type11transactions = type11transactions;
    }

    public int getType12transactions() {
        return type12transactions;
    }

    public void setType12transactions(int type12transactions) {
        this.type12transactions = type12transactions;
    }

    public int getType13transactions() {
        return type13transactions;
    }

    public void setType13transactions(int type13transactions) {
        this.type13transactions = type13transactions;
    }

    public int getType14transactions() {
        return type14transactions;
    }

    public void setType14transactions(int type14transactions) {
        this.type14transactions = type14transactions;
    }

    public int getBlocksize() {
        return blocksize;
    }

    public void setBlocksize(int blockSize) {
        this.blocksize = blockSize;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

}
