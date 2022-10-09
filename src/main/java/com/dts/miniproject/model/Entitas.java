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
public class Entitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomor_induk", unique = true)
    private Long nomorInduk;
    private String nama;
    private String alamat;
    private String email;
    @Column(name = "no_hp")
    private String noHp;

    @ManyToMany
    @JoinTable(name = "entitas_matapelajaran", joinColumns = @JoinColumn(name = "entitas_id"), inverseJoinColumns = @JoinColumn(name = "matpel_id"))
    List<MataPelajaran> mataPelajarans;

    @OneToOne(mappedBy = "entitas")
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(mappedBy = "entitas")
    private List<JadwalPelajaran> jadwalPelajarans;

}
