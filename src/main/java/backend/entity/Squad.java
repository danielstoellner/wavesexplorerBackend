package backend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Squad")
public class Squad {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String currency;
    @ManyToMany(mappedBy = "squads")
    private Set<User> users = new HashSet<>();

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Squad() {
    }

    public Squad(String name, String currency){
        this.name = name;
        this.currency = currency;
}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
