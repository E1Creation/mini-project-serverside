package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Entitas;
import com.dts.miniproject.repository.EntitasRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntitasService {
    private EntitasRepository entitasRepository;

    public List<Entitas> getAll() {
        return entitasRepository.findAll();
    }

    public Entitas getById(Long id) {
        return entitasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Entitas tidak ditemukan"));
    }

    public Entitas create(Entitas entitas) {
        if (entitas.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id Entitas tidak ditemukan");
        }
        validateByName(entitas.getNama());
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
