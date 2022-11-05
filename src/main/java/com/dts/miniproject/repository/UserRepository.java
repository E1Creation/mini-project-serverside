package com.dts.miniproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.User;
import com.dts.miniproject.repository.generic.GenericRepository;

@Repository
public interface UserRepository extends GenericRepository<User> {
    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
