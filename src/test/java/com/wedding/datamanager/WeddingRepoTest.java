package com.wedding.datamanager;

import com.wedding.datamanager.services.WeddingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.wedding.datamanager.domain.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by pipe on 8/8/17.
 */


@RunWith( SpringRunner.class )
@SpringBootTest()
public class WeddingRepoTest {
    @Autowired
    private WeddingService weddingService;


/*    @Before
    public void setUp() throws Exception {
        Wedding wedding = new Wedding();
        wedding.setOwner(new Owner());
        Guest alex = new Guest();
        alex.setName("alex");
        wedding.getGuests().add(alex);
        wedding.getOwner().setName("Andres Arango");
        wedding.setEmail("pipe1411@gmail.com");
        this.weddingService.saveWedding(wedding);

    }*/



    @Test
    public void testFetchData() throws Exception {
        Iterable<Wedding> weddings = this.weddingService.findAllWeddings();
        for (Wedding wedding : weddings) {
            assertEquals("Andres Arango",wedding.getOwner().getName());
        }
    }

    @Test
    public void testId() throws Exception {
        Wedding wedding = weddingService.getWeddingById("pipe1411@gmail.com");
        assertNotNull(wedding);
        assertEquals("Andres Arango",wedding.getOwner().getName());
        assertEquals("pipe1411@gmail.com",wedding.getEmail());
    }

    @Test
    public void testAddGuest() throws Exception {
        Guest guest = new Guest();
        guest.setName("Daniel Arango");
        weddingService.addGuest("pipe1411@gmail.com",guest);
        Wedding wedding = weddingService.getWeddingById("pipe1411@gmail.com");
        assertEquals(4,wedding.getGuests().size());
    }


    @Test
    public void testAddMultipleGuests() throws Exception {
        List<Guest> guestList = new ArrayList<>();
        Guest norma = new Guest();
        norma.setName("norma");
        Guest luis = new Guest();
        luis.setName("luis");
        guestList.add(norma);
        guestList.add(luis);
        weddingService.addGuests("pipe1411@gmail.com",guestList);
        Wedding myWedding = weddingService.getWeddingById("pipe1411@gmail.com");
        List<Guest> savedGuests = myWedding.getGuests();
        for (Guest guest:savedGuests) {
            System.out.println("Your Guest name: " + guest.getName());
        }
    }


}
