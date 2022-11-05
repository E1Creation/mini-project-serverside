package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Kelas;
import com.dts.miniproject.repository.KelasRepository;
import com.dts.miniproject.repository.generic.GenericRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KelasService {
    private GenericRepository<Kelas> kelasRepository;

    public List<Kelas> getAll() {
        return kelasRepository.findAll();
    }

    public Kelas getById(Long id) {
        return kelasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Kelas tidak ditemukan"));
    }

    public Kelas create(Kelas kelas) {
        if (kelas.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id Kelas tidak ditemukan");
        }
        return kelasRepository.save(kelas);
    }

    public Kelas update(Long id, Kelas kelas) {
        Kelas oldKelas = getById(id);
        if (oldKelas.getId() == kelas.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama Kelas sama");
        }
        kelas.setId(id);
        return kelasRepository.save(kelas);
    }

    public Kelas delete(Long id) {
        Kelas kelas = getById(id);
        kelasRepository.delete(kelas);
        return kelas;
    }

}
