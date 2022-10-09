package com.dts.miniproject.model.dto.mapper;

import com.dts.miniproject.model.Entitas;
import com.dts.miniproject.model.User;
import com.dts.miniproject.model.dto.EntitasRequest;

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
}
