package com.dts.miniproject.model;

import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Entitas extends BaseEntity {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    @Column(name = "nomor_induk", unique = true)
    private Long nomorInduk;
    private String nama;
    private String alamat;
    private String email;
    @Column(name = "no_hp")
    private String noHp;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "entitas")
    List<MataPelajaran> mataPelajarans;

    @OneToOne(mappedBy = "entitas", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    // @JsonProperty(access = Access.WRITE_ONLY)
    // @ManyToMany
    // @JoinTable(name = "self_entitas", joinColumns = @JoinColumn(name =
    // "guru_id"), inverseJoinColumns = @JoinColumn(name = "siswa_id"))
    // List<Entitas> guru;

    // @JsonProperty(access = Access.WRITE_ONLY)
    // @ManyToMany
    // @JoinTable(name = "self_entitas", joinColumns = @JoinColumn(name =
    // "siswa_id"), inverseJoinColumns = @JoinColumn(name = "guru_id"))
    // List<Entitas> siswa;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "entitas")
    private List<Rapot> rapots;
}
