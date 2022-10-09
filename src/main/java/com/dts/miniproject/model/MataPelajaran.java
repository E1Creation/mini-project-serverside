package com.dts.miniproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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

    @ManyToMany(mappedBy = "mataPelajarans")
    private List<Guru> gurus;

    @ManyToMany(mappedBy = "mataPelajarans")
    private List<Siswa> siswas;

    @ManyToMany(mappedBy = "mataPelajarans")
    private List<Entitas> entitas;

    @OneToMany(mappedBy = "mataPelajarans")
    private List<JadwalPelajaran> jadwalPelajaran;

    @OneToMany(mappedBy = "mataPelajarans")
    private List<Rapot> rapots;
}
