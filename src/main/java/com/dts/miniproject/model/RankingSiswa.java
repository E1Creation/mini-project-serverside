package com.dts.miniproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RankingSiswa {

    @Id
    private Long id;
    private int rank;

    private int rapot;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Siswa siswa;

}
