import backend.entity.Squad;
import backend.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private Squad squad = new Squad("Group1", "KeplerToken");
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Hannah","Fehringer","HannahF","3PHT9znPcDB9MQ9P4d4uVbkxfXfAggg1nVA");
        Set<User> users = new HashSet<>();
        squad.setUsers(users);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
        assertEquals(0, user.getId());
    }

    @Test
    void setId() {
        user.setId(3);
        assertEquals(3, user.getId());
    }

    @Test
    void getGivenname() {
        assertEquals("Hannah", user.getGivenname());
    }

    @Test
    void setGivenname() {
        user.setGivenname("Mühlwanger");
        assertEquals("Mühlwanger", user.getGivenname());
    }

    @Test
    void getSurename() {
        assertEquals("Fehringer", user.getSurename());
    }

    @Test
    void setSurename() {
        user.setSurename("Nadine");
        assertEquals("Nadine", user.getSurename());
    }

    @Test
    void getUsername() {
        assertEquals("HannahF", user.getUsername());
    }

    @Test
    void setUsername() {
        user.setUsername("NadineF");
        assertEquals("NadineF", user.getUsername());
    }

    @Test
    void getAddress() {
        assertEquals("3PHT9znPcDB9MQ9P4d4uVbkxfXfAggg1nVA", user.getAddress());
    }

    @Test
    void setAddress() {
        user.setAddress("3PEyJbYQHWXcfenvpqgRKQ9LFHbVSPier5x");
        assertEquals("3PEyJbYQHWXcfenvpqgRKQ9LFHbVSPier5x", user.getAddress());
    }

    @Test
    void getSquads() {
    }

    @Test
    void setSquads() {
    }

}