package com.dts.miniproject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntitasUser {
    private Long id;
    private Long nomorInduk;
    private String nama;
    private String alamat;
    private String username;
    private String password;
}
