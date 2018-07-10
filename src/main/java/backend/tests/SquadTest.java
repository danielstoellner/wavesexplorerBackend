package tests;

import backend.entity.Squad;
import backend.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.*;


class SquadTest {
    Squad n;

    @BeforeEach
    void setUp() {
        n = new Squad("Group1", "KeplerToken");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setUsers() {
        User one = new User("Hannah", "Fehringer", "Hannahf", "3PHT9znPcDB9MQ9P4d4uVbkxfXfAggg1nVA");
        User two = new User("Stefan", "Rechberger", "StefanR", "3PFLP8w1sPko1C4GbHdL1PZGRscCumgQ1QG");
        Set<User> set = new HashSet<User>();
        set.add(one);
        set.add(two);
        n.setUsers(set);
        assertNotEquals(0, n.getUsers().size());
        assertEquals(true, n.getUsers().contains(one));
    }

    @Test
    void getId() {
        assertEquals(0, n.getId());
    }

    @Test
    void setId() {
        n.setId(3);
        assertEquals(3, n.getId());
    }

    @Test
    void getName() {
        assertEquals("Group1", n.getName());
    }

    @Test
    void setName() {
        n.setName("Blockchain");
        assertEquals("Blockchain", n.getName());
    }

    @Test
    void getCurrency() {
        assertEquals("KeplerToken", n.getCurrency());
    }

    @Test
    void setCurrency() {
        n.setName("Waves");
        assertEquals("Waves", n.getName());
    }

}