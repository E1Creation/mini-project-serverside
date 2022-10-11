package com.dts.miniproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MataPelajaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;

    // @ManyToMany(mappedBy = "mataPelajarans")
    // private List<Guru> gurus;

    // @ManyToMany(mappedBy = "mataPelajarans")
    // private List<Siswa> siswas;

    // @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "mataPelajarans")
    private List<Entitas> entitas;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "mataPelajarans")
    private List<JadwalPelajaran> jadwalPelajaran;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "mataPelajarans")
    private List<Rapot> rapots;
}
