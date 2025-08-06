package com.andac.eventmanager.repository;

import com.andac.eventmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository, User entity'si için CRUD işlemlerini sağlar.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // İstersek özel sorgular da ekleyebiliriz
}
