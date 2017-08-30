package com.wedding.datamanager.services;

import com.wedding.datamanager.domain.Guest;
import com.wedding.datamanager.domain.Wedding;
import com.wedding.datamanager.repositories.WeddingRepositoryCustom;
import org.springframework.stereotype.Component;

/**
 * Created by pipe on 8/8/17.
 */

@Component
public interface WeddingService extends WeddingRepositoryCustom {
    Wedding saveWedding(Wedding wedding);

    Iterable<Wedding> findAllWeddings();

    Wedding getWeddingById(String id);

    void deleteAll();

    boolean addGuest(String id, Guest guest);
}
