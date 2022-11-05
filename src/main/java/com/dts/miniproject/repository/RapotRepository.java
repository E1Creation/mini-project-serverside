package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.Rapot;
import com.dts.miniproject.repository.generic.GenericRepository;

@Repository
public interface RapotRepository extends GenericRepository<Rapot> {

}
