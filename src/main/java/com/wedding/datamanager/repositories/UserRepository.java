package com.wedding.datamanager.repositories;

import com.wedding.datamanager.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pipe on 8/27/17.
 */

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);
}
