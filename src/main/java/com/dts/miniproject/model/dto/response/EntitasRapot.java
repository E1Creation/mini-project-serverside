package com.dts.miniproject.model.dto.response;

import java.util.List;

import com.dts.miniproject.model.Rapot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntitasRapot {
    private Long id;
    private Long nomorInduk;
    private String nama;
    private String alamat;
    private String email;
    private String noHp;
    private List<Rapot> rapots;
}
