package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.MataPelajaran;

@Repository
public interface MataPelajaranRepository extends JpaRepository<MataPelajaran, Long> {
    Boolean existsByNama(String nama);
}
