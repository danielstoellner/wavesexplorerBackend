package backend.entity.request;

public class AddGroupRequest {

    private String name;
    private String currency;

    public String getName() {
        return name;
    }

    public void setGivenName(String givenName) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
