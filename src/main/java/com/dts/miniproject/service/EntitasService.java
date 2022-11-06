package com.dts.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Entitas;
import com.dts.miniproject.model.Role;
import com.dts.miniproject.model.User;
import com.dts.miniproject.model.dto.response.CountEntitasMatpel;
import com.dts.miniproject.model.dto.response.EntitasRapot;
import com.dts.miniproject.model.dto.response.EntitasUser;
import com.dts.miniproject.repository.EntitasRepository;
import com.dts.miniproject.repository.MataPelajaranRepository;
import com.dts.miniproject.service.generic.GenericService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntitasService extends GenericService<Entitas> {
    private EntitasRepository entitasRepository;
    private RoleService roleService;
    private MataPelajaranRepository mataPelajaranRepository;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    // @Bean
    // public void setup() {
    // this.mapper = new ModelMapper();
    // }

    // public List<Entitas> getAll() {
    // return entitasRepository.findAll();
    // }

    // public Entitas getById(Long id) {
    // return entitasRepository.findById(id)
    // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data
    // Entitas tidak ditemukan"));
    // }

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

        // if (entitas.getUser().getUsername() == null) {
        // throw new ResponseStatusException(HttpStatus.CONFLICT, "username kosong");
        // }
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

    public CountEntitasMatpel countEntitasMatpel() {
        Integer jumlah_siswa = entitasRepository.countEntitas(1);
        Integer jumlah_guru = entitasRepository.countEntitas(2);
        Integer jumlah_mata_pelajaran = mataPelajaranRepository.countMatpel();

        return new CountEntitasMatpel(jumlah_siswa, jumlah_guru, jumlah_mata_pelajaran);

    }

    public EntitasRapot mapperEntitasRapotFromEntitas(Long id) {
        ModelMapper mapper = new ModelMapper();
        Entitas entitas = getById(id);
        EntitasRapot entitasRapot = mapper.map(entitas, EntitasRapot.class);
        return entitasRapot;
    }

    public EntitasUser mapperEntitasUser(Long id) {
        ModelMapper mapper = new ModelMapper();
        Entitas entitas = getById(id);
        User user = userService.getById(id);
        EntitasUser entitasUser = mapper.map(entitas, EntitasUser.class);
        mapper.map(user, entitasUser);
        return entitasUser;
    }

}
