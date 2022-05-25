package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends MongoRepository<User, String > {
    List<User> findByaddressContaining(String address);
    List<User> findBydateOfBirth(String dateOfBirth);

}
