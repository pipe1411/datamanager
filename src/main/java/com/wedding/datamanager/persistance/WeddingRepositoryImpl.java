package com.wedding.datamanager.persistance;

import com.mongodb.WriteResult;
import com.wedding.datamanager.DemoApplication;
import com.wedding.datamanager.repositories.WeddingRepositoryCustom;
import com.wedding.datamanager.domain.Guest;
import com.wedding.datamanager.domain.Wedding;
import com.wedding.datamanager.repositories.WeddingRepository;
import com.wedding.datamanager.services.WeddingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;


/**
 * Created by pipe on 8/8/17.
 */

@Service
@Transactional
public class WeddingRepositoryImpl implements WeddingService,WeddingRepositoryCustom {
    @Autowired
    private WeddingRepository weddingRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Logger log = Logger.getLogger(DemoApplication.class);

    @Override
    public Wedding saveWedding(Wedding wedding) {
        if (!weddingRepository.exists(wedding.getEmail())) {
            return weddingRepository.insert(wedding);
        }
        else {
            log.warn("UNABLE TO ADD WEDDING, LIMITED TO ONE AT THE MOMENT");
            return null;
        }
    }

    @Override
    public Iterable<Wedding> findAllWeddings() {
        return weddingRepository.findAll();
    }

    @Override
    public Wedding getWeddingById(String id) {
        return weddingRepository.findOne(id);
    }

    @Override
    public void deleteAll() {
        weddingRepository.deleteAll();
    }

    @Override
    public boolean addGuest(String id, Guest guest) {
        Query query = new Query(Criteria.where("email").is(id));
        Update update = new Update();
        update.addToSet("guests",guest);


        WriteResult writeResult = mongoTemplate.updateFirst(query,update,Wedding.class);

        if (writeResult.isUpdateOfExisting()) {
            log.debug("ADDED GUEST TO FOLLOWING ACCOUNT EMAIL: " + id);
            return true;
        }else {
            log.warn("UNABLE TO ADD GUEST");
            return false;
        }


    }

    @Override
    public boolean addGuests(String id, List<Guest> guests) {
        Query query = new Query(Criteria.where("email").is(id));
        Update update = new Update();
        update.addToSet("guests",guests);

        WriteResult writeResult = mongoTemplate.updateFirst(query,update,Wedding.class);
        return writeResult.getN() == 0 ? false:true;
    }


}
