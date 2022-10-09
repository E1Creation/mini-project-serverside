package com.dts.miniproject.model.dto.mapper;

import com.dts.miniproject.model.Entitas;
import com.dts.miniproject.model.JadwalPelajaran;
import com.dts.miniproject.model.User;
import com.dts.miniproject.model.dto.EntitasRequest;
import com.dts.miniproject.model.dto.request.AddKelasMatpelToJadwal;

public class Mapper {

    static public EntitasRequest toEntitasRequest(Entitas entitas) {

        return new EntitasRequest(entitas.getNama(), entitas.getNomorInduk(), entitas.getAlamat(), entitas.getEmail(),
                entitas.getNoHp(), entitas.getUser().getUsername(), entitas.getUser().getPassword());
    }

    static public Entitas toEntitas(EntitasRequest entitasRequest) {
        User user = new User();
        user.setUsername(entitasRequest.getUsername());
        user.setPassword(entitasRequest.getPassword());
        return new Entitas(null, entitasRequest.getNomorInduk(), entitasRequest.getNama(), entitasRequest.getAlamat(),
                entitasRequest.getEmail(), entitasRequest.getNoHp(), null, user);
    }

    static public AddKelasMatpelToJadwal toAddKelasMatpelToJadwal(JadwalPelajaran jadwalPelajaran) {
        return new AddKelasMatpelToJadwal(jadwalPelajaran.getHari(), jadwalPelajaran.getJamMasuk(),
                jadwalPelajaran.getJamKeluar(), jadwalPelajaran.getMataPelajarans().getId(),
                jadwalPelajaran.getMataPelajarans().getId());
    }

    static public JadwalPelajaran toJadwalPelajaran(AddKelasMatpelToJadwal addKelasMatpelToJadwal) {
        return new JadwalPelajaran(null, addKelasMatpelToJadwal.getHari(), addKelasMatpelToJadwal.getJamMasuk(),
                addKelasMatpelToJadwal.getJamKeluar(), null, null);
    }
}
