package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.Rapot;

@Repository
public interface RapotRepository extends JpaRepository<Rapot, Long> {

}
