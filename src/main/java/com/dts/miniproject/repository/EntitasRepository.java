package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.Entitas;

@Repository
public interface EntitasRepository extends JpaRepository<Entitas, Long> {
    Boolean existsByNama(String nama);

    @Query(value = "SELECT COUNT(user.id) FROM user JOIN user_role on user.id = user_role.user_id where user_role.role_id = ?1", nativeQuery = true)
    Integer countEntitas(int role);
}
