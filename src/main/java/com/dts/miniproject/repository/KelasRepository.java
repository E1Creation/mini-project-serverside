package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.Kelas;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Long> {

}
