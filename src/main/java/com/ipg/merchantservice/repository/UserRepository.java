package com.ipg.merchantservice.repository;

import com.ipg.merchantservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findFirstByEmail(String email);
    Optional<User> findFirstById(String id);
}
