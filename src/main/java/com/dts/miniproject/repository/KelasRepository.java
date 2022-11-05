package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.Kelas;
import com.dts.miniproject.repository.generic.GenericRepository;

@Repository
public interface KelasRepository extends GenericRepository<Kelas> {

}
