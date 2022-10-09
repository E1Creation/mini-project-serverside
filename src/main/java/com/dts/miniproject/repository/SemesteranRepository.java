package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.Semesteran;

@Repository
public interface SemesteranRepository extends JpaRepository<Semesteran, Long> {

}
