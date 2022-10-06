package io.ke.web.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.ke.web.models.User;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    User findByEmailId(String emailId);

    @Query("SELECT count(emailId) FROM User WHERE emailId=:emailId")
    int isEmailPresent(@Param("emailId") String emailId);
}