package backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BlockTransaction")
public class BlockTransaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private Date date;
    private long countBlocks;
    private long avgBlocks;
    private long totalBlockSize;
    private long countTransactions;
    private long type_1;
    private long type_2;
    private long type_3;
    private long type_4;
    private long type_5;
    private long type_6;
    private long type_7;
    private long type_8;
    private long type_9;
    private long type_10;
    private long type_11;
    private long type_12;
    private long type_13;
    private long type_14;
    private long type_15;

    public BlockTransaction(){};

    public BlockTransaction(
            Date date,
            long countBlocks,
            long avgBlocks,
            long totalBlockSize,
            long countTransactions,
            long type_1,
            long type_2,
            long type_3,
            long type_4,
            long type_5,
            long type_6,
            long type_7,
            long type_8,
            long type_9,
            long type_10,
            long type_11,
            long type_12,
            long type_13,
            long type_14,
            long type_15
    ){
        this.date = date;
        this.countBlocks = countBlocks;
        this.avgBlocks = avgBlocks;
        this.totalBlockSize = totalBlockSize;
        this.countTransactions = countTransactions;
        this.type_1 = type_1;
        this.type_2 = type_2;
        this.type_3 = type_3;
        this.type_4 = type_4;
        this.type_5 = type_5;
        this.type_6 = type_6;
        this.type_7 = type_7;
        this.type_8 = type_8;
        this.type_9 = type_9;
        this.type_10 = type_10;
        this.type_11 = type_11;
        this.type_12 = type_12;
        this.type_13 = type_13;
        this.type_14 = type_14;
        this.type_15 = type_15;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCountBlocks() {
        return countBlocks;
    }

    public void setCountBlocks(long countBlocks) {
        this.countBlocks = countBlocks;
    }

    public long getAvgBlocks() {
        return avgBlocks;
    }

    public void setAvgBlocks(long avgBlocks) {
        this.avgBlocks = avgBlocks;
    }

    public long getTotalBlockSize() {
        return totalBlockSize;
    }

    public void setTotalBlockSize(long totalBlockSize) {
        this.totalBlockSize = totalBlockSize;
    }

    public long getCountTransactions() {
        return countTransactions;
    }

    public void setCountTransactions(long countTransactions) {
        this.countTransactions = countTransactions;
    }

    public long getType_1() {
        return type_1;
    }

    public void setType_1(long type_1) {
        this.type_1 = type_1;
    }

    public long getType_2() {
        return type_2;
    }

    public void setType_2(long type_2) {
        this.type_2 = type_2;
    }

    public long getType_3() {
        return type_3;
    }

    public void setType_3(long type_3) {
        this.type_3 = type_3;
    }

    public long getType_4() {
        return type_4;
    }

    public void setType_4(long type_4) {
        this.type_4 = type_4;
    }

    public long getType_5() {
        return type_5;
    }

    public void setType_5(long type_5) {
        this.type_5 = type_5;
    }

    public long getType_6() {
        return type_6;
    }

    public void setType_6(long type_6) {
        this.type_6 = type_6;
    }

    public long getType_7() {
        return type_7;
    }

    public void setType_7(long type_7) {
        this.type_7 = type_7;
    }

    public long getType_8() {
        return type_8;
    }

    public void setType_8(long type_8) {
        this.type_8 = type_8;
    }

    public long getType_9() {
        return type_9;
    }

    public void setType_9(long type_9) {
        this.type_9 = type_9;
    }

    public long getType_10() {
        return type_10;
    }

    public void setType_10(long type_10) {
        this.type_10 = type_10;
    }

    public long getType_11() {
        return type_11;
    }

    public void setType_11(long type_11) {
        this.type_11 = type_11;
    }

    public long getType_12() {
        return type_12;
    }

    public void setType_12(long type_12) {
        this.type_12 = type_12;
    }

    public long getType_13() {
        return type_13;
    }

    public void setType_13(long type_13) {
        this.type_13 = type_13;
    }

    public long getType_14() {
        return type_14;
    }

    public void setType_14(long type_14) {
        this.type_14 = type_14;
    }

    public long getType_15() {
        return type_15;
    }

    public void setType_15(long type_15) {
        this.type_15 = type_15;
    }
}
