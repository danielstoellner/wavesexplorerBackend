package backend.entity;

public class Transaction {


    private String id;
    private int type;
    private String sender;
    private String reciepient;

    private long amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciepient() {
        return reciepient;
    }

    public void setReciepient(String reciepient) {
        this.reciepient = reciepient;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
