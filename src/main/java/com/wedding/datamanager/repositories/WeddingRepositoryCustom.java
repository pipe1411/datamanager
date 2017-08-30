package com.wedding.datamanager.repositories;

import com.wedding.datamanager.domain.Guest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pipe on 8/8/17.
 */


public interface WeddingRepositoryCustom {
    boolean addGuest(String id, Guest guest);
    boolean addGuests(String id, List<Guest> guests);
}
