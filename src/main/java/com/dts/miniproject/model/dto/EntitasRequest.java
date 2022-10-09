package com.dts.miniproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntitasRequest {
    private String nama;
    private Long nomorInduk;
    private String alamat;
    private String email;
    private String noHp;
    private String username;
    private String password;
}
