package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Semesteran;
import com.dts.miniproject.repository.SemesteranRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SemesteranService {
    private SemesteranRepository semesteranRepository;

    public List<Semesteran> getAll() {
        return semesteranRepository.findAll();
    }

    public Semesteran getById(Long id) {
        return semesteranRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Semesteran tidak ditemukan"));
    }

    public Semesteran create(Semesteran semesteran) {
        if (semesteran.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id Semesteran tidak ditemukan");
        }
        return semesteranRepository.save(semesteran);
    }

    public Semesteran update(Long id, Semesteran semesteran) {
        Semesteran oldSemesteran = getById(id);
        if (oldSemesteran.getId() == semesteran.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama Semesteran sama");
        }
        semesteran.setId(id);
        return semesteranRepository.save(semesteran);
    }

    public Semesteran delete(Long id) {
        Semesteran semesteran = getById(id);
        semesteranRepository.delete(semesteran);
        return semesteran;
    }

}
