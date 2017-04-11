package model.user;

import model.Threshold;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gabriel on 10/04/17.
 */
public class ProfileTest {
    private Profile profile;
    private String name;
    private String lastName;
    private String address;

    @Before
    public void setUp() throws Exception {
        name        = "Juan";
        lastName    = "Perez";
        address     = "Calle Falsa 123";
        profile     = new Profile();
    }

    @Test
    public void getAddress() throws Exception {
        profile = new Profile(name, lastName, address);

        assertEquals(address, profile.getAddress());
    }

    @Test
    public void setAddress() throws Exception {
        profile.setAddress(address);

        assertEquals(address, profile.getAddress());
    }


    @Test
    public void setName() throws Exception {
        profile.setName(name);

        assertEquals(name, profile.getName());
    }


    @Test
    public void setLastName() throws Exception {
        profile.setLastName(lastName);

        assertEquals(lastName, profile.getLastName());
    }

    @Test
    public void testSetThresholds() throws Exception {
        List<Threshold> thresholds = new ArrayList<>();
        profile.setThresholds(thresholds);

        assertEquals(thresholds, profile.getThresholds());
    }
}