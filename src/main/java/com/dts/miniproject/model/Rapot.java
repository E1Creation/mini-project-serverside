package com.dts.miniproject.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rapot extends BaseEntity {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    private int nilai;

    @ManyToOne
    @JoinColumn(name = "mataPelajarans")
    private MataPelajaran mataPelajarans;

    // @ManyToOne
    // @JoinColumn(name = "siswa")
    // private Siswa siswa;
    // @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "entitas")
    private Entitas entitas;

    private int semester;

}
