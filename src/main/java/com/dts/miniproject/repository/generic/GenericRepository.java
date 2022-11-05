package com.dts.miniproject.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dts.miniproject.model.BaseEntity;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
