package com.dts.miniproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tingkatan;

    private String kode;

    @OneToMany(mappedBy = "kelas")
    private List<Siswa> siswas;

    @OneToMany(mappedBy = "kelas")
    private List<JadwalPelajaran> jadwalPelajarans;
}
