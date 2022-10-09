package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.Entitas;

@Repository
public interface EntitasRepository extends JpaRepository<Entitas, Long> {
    Boolean existsByNama(String nama);
}
