package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Entitas;
import com.dts.miniproject.model.MataPelajaran;
import com.dts.miniproject.model.Rapot;
import com.dts.miniproject.model.dto.mapper.Mapper;
import com.dts.miniproject.model.dto.response.EntitasRapot;
import com.dts.miniproject.repository.generic.GenericRepository;
import com.dts.miniproject.service.generic.GenericService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RapotService extends GenericService<Rapot> {
    private GenericRepository<Rapot> rapotRepository;
    private MataPelajaranService mataPelajaranService;
    private EntitasService entitasService;

    // public List<Rapot> getAll() {
    // return rapotRepository.findAll();
    // }

    // public Rapot getById(Long id) {
    // return rapotRepository.findById(id)
    // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data
    // Rapot tidak ditemukan"));
    // }

    public Rapot create(Rapot rapot) {
        if (rapot.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id Rapot tidak ditemukan");
        }
        MataPelajaran mataPelajaran = mataPelajaranService.getById(rapot.getMataPelajarans().getId());
        Entitas entitas = entitasService.getById(rapot.getEntitas().getId());
        rapot.setEntitas(entitas);
        rapot.setMataPelajarans(mataPelajaran);
        return rapotRepository.save(rapot);
    }

    public Rapot update(Long id, Rapot rapot) {
        Rapot oldRapot = getById(id);
        if (oldRapot.getId() == rapot.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama Rapot sama");
        }
        rapot.setId(id);
        MataPelajaran mataPelajaran = mataPelajaranService.getById(rapot.getMataPelajarans().getId());
        Entitas entitas = entitasService.getById(rapot.getEntitas().getId());
        rapot.setEntitas(entitas);
        rapot.setMataPelajarans(mataPelajaran);
        return rapotRepository.save(rapot);
    }

    // public Rapot delete(Long id) {
    // Rapot rapot = getById(id);
    // rapotRepository.delete(rapot);
    // return rapot;
    // }

    public EntitasRapot getEntitasRapotByid(Long id) {
        Entitas entitas = entitasService.getById(id);

        return Mapper.toEntitasRapot(entitas, getAll());
    }
}
