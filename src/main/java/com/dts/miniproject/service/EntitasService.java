package com.dts.miniproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Entitas;
import com.dts.miniproject.model.Role;
import com.dts.miniproject.model.User;
import com.dts.miniproject.model.dto.mapper.Mapper;
import com.dts.miniproject.model.dto.response.EntitasRapot;
import com.dts.miniproject.repository.EntitasRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntitasService {
    private EntitasRepository entitasRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    public List<Entitas> getAll() {
        return entitasRepository.findAll();
    }

    public Entitas getById(Long id) {
        return entitasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Entitas tidak ditemukan"));
    }

    public List<Entitas> getAllByRole(Long id) {
        List<Entitas> newEntitas = new ArrayList<>();
        for (Entitas en : getAll()) {
            for (Role rol : en.getUser().getRoles()) {
                if (rol.getId() == id) {
                    newEntitas.add(en);
                }
            }
        }
        return newEntitas;

    }

    public Entitas create(Entitas entitas) {
        if (entitas.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id Entitas tidak ditemukan");
        }
        validateByName(entitas.getNama());
        User user = entitas.getUser();
        user.setPassword(passwordEncoder.encode(entitas.getUser().getPassword()));
        user.setIsEnabled(Boolean.TRUE);
        user.setIsAccountLocked(Boolean.FALSE);
        entitas.setUser(user);
        entitas.getUser().setEntitas(entitas);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(1L));
        entitas.getUser().setRoles(roles);

        return entitasRepository.save(entitas);
    }

    public Entitas update(Long id, Entitas entitas) {
        Entitas oldEntitas = getById(id);
        if (oldEntitas.getId() == entitas.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama Entitas sama");
        }
        entitas.setId(id);
        return entitasRepository.save(entitas);
    }

    public Entitas delete(Long id) {
        Entitas entitas = getById(id);
        entitasRepository.delete(entitas);
        return entitas;
    }

    public void validateByName(String name) {
        if (entitasRepository.existsByNama(name)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama Entitas sudah ada");
        }
    }

}
