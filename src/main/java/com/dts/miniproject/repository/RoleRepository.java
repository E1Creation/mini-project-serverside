package com.dts.miniproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.Role;
import com.dts.miniproject.repository.generic.GenericRepository;

@Repository
public interface RoleRepository extends GenericRepository<Role> {
    Boolean existsByName(String name);

    Optional<Role> findByName(String name);
}
