package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.JadwalPelajaran;

@Repository
public interface JadwalPelajaranRepository extends JpaRepository<JadwalPelajaran, Long> {

}
