package com.dts.miniproject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountEntitasMatpel {
    Integer jumlah_siswa;
    Integer jumlah_guru;
    Integer jumlah_mata_pelajaran;
}
