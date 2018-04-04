package backend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String givenname;
    private String surename;
    private String username;
    private String address;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "User_Squad",
            joinColumns = {@JoinColumn(name ="user_id")},
            inverseJoinColumns = {@JoinColumn(name="squad_id")}
    )
    private Set<Squad> squads = new HashSet<>();

    public User (){};

    public User (String givenname, String surname, String username, String address){
        this.givenname = givenname;
        this.surename = surname;
        this.username = username;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Squad> getSquads() {
        return squads;
    }

    public void setSquads(Set<Squad> squads) {
        this.squads = squads;
    }
}
