package com.dts.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.RankingSiswa;

@Repository
public interface RankingSiswaRepository extends JpaRepository<RankingSiswa, Long> {
    Boolean existsByRank(int rank);
}
