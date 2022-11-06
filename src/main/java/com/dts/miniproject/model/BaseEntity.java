package com.dts.miniproject.model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    // @Column(name = "created_date", nullable = false, updatable = false)
    // @CreationTimestamp
    // private Date createdDate;
    // @Column(name = "updated_date", nullable = true)
    // @UpdateTimestamp
    // private Date updatedDate;

    // public BaseEntity(Long id) {
    // this.id = id;
    // }
}
