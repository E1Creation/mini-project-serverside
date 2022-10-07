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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NIP;
    private String nama;
    private String alamat;
    private String email;
    @Column(name = "no_hp")
    private String noHp;

    @ManyToMany
    @JoinTable(name = "guru_pelajaran", joinColumns = @JoinColumn(name = "guru_id"), inverseJoinColumns = @JoinColumn(name = "matpel_id"))
    List<MataPelajaran> mataPelajarans;

    @OneToOne(mappedBy = "guru")
    @PrimaryKeyJoinColumn
    private User user;
}
