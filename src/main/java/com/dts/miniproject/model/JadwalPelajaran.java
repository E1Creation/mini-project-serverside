package com.dts.miniproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JadwalPelajaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "jam_masuk")
    private int jamMasuk;
    @Column(name = "jam_keluar")
    private int jamKeluar;

    @ManyToMany
    @JoinTable(name = "jadwal_MataPelajaran", joinColumns = @JoinColumn(name = "jadwal_id"), inverseJoinColumns = @JoinColumn(name = "matpel_id"))
    private List<MataPelajaran> mataPelajarans;

    @ManyToOne
    @JoinColumn(name = "kelas")
    private Kelas kelas;

}
