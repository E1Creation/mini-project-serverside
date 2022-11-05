package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.MataPelajaran;
import com.dts.miniproject.repository.generic.GenericRepository;

@Repository
public interface MataPelajaranRepository extends GenericRepository<MataPelajaran> {
    Boolean existsByNama(String nama);

    @Query(value = "SELECT COUNT(nama) from mata_pelajaran", nativeQuery = true)
    Integer countMatpel();
}
