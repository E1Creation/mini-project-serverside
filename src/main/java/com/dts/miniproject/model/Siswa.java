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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NIS;

    private String nama;

    private String alamat;

    @Column(name = "no_telp_ortu")
    private String noTelpOrtu;

    @ManyToMany
    @JoinTable(name = "siswa_pelajaran", joinColumns = @JoinColumn(name = "siswa_id"), inverseJoinColumns = @JoinColumn(name = "matpel_id"))
    private List<MataPelajaran> mataPelajarans;

    @OneToOne(mappedBy = "siswa")
    @PrimaryKeyJoinColumn
    private User user;

    @OneToOne(mappedBy = "siswa")
    @PrimaryKeyJoinColumn
    private RankingSiswa rankingSiswa;

    @ManyToOne
    @JoinColumn(name = "kelas")
    private Kelas kelas;

    @OneToMany(mappedBy = "siswa")
    private List<Rapot> rapot;

}
