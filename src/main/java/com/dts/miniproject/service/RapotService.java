package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Rapot;
import com.dts.miniproject.repository.RapotRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RapotService {
    private RapotRepository rapotRepository;

    public List<Rapot> getAll() {
        return rapotRepository.findAll();
    }

    public Rapot getById(Long id) {
        return rapotRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Rapot tidak ditemukan"));
    }

    public Rapot create(Rapot rapot) {
        if (rapot.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id Rapot tidak ditemukan");
        }
        return rapotRepository.save(rapot);
    }

    public Rapot update(Long id, Rapot rapot) {
        Rapot oldRapot = getById(id);
        if (oldRapot.getId() == rapot.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama Rapot sama");
        }
        rapot.setId(id);
        return rapotRepository.save(rapot);
    }

    public Rapot delete(Long id) {
        Rapot rapot = getById(id);
        rapotRepository.delete(rapot);
        return rapot;
    }

}
