package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.MataPelajaran;
import com.dts.miniproject.repository.MataPelajaranRepository;

@Service
public class MataPelajaranService {
    private MataPelajaranRepository matapelajaranRepository;

    public List<MataPelajaran> getAll() {
        return matapelajaranRepository.findAll();
    }

    public MataPelajaran getById(Long id) {
        return matapelajaranRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data MataPelajaran tidak ditemukan"));
    }

    public MataPelajaran create(MataPelajaran matapelajaran) {
        if (matapelajaran.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id MataPelajaran tidak ditemukan");
        }
        validateByName(matapelajaran.getNama());
        return matapelajaranRepository.save(matapelajaran);
    }

    public MataPelajaran update(Long id, MataPelajaran matapelajaran) {
        MataPelajaran oldMataPelajaran = getById(id);
        if (oldMataPelajaran.getId() == matapelajaran.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama MataPelajaran sama");
        }
        matapelajaran.setId(id);
        return matapelajaranRepository.save(matapelajaran);
    }

    public MataPelajaran delete(Long id) {
        MataPelajaran matapelajaran = getById(id);
        matapelajaranRepository.delete(matapelajaran);
        return matapelajaran;
    }

    public void validateByName(String name) {
        if (matapelajaranRepository.existsByNama(name)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama MataPelajaran sudah ada");
        }

    }
}
