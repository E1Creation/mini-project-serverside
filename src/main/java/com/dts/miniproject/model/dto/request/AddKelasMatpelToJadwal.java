package com.dts.miniproject.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddKelasMatpelToJadwal {
    private String hari;
    private int jamMasuk;
    private int jamKeluar;
    private Long idMatpel;
    private Long idKelas;
}
