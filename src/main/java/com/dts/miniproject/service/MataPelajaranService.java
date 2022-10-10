package com.dts.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Entitas;
import com.dts.miniproject.model.MataPelajaran;
import com.dts.miniproject.model.Role;
import com.dts.miniproject.model.dto.request.AddEntitasToMatpel;
import com.dts.miniproject.repository.MataPelajaranRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MataPelajaranService {
    private MataPelajaranRepository matapelajaranRepository;
    private EntitasService entitasService;

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

    public MataPelajaran addEntitasToMatpel(AddEntitasToMatpel addEntitasToMatpel) {
        MataPelajaran mataPelajaran = new MataPelajaran();
        mataPelajaran.setNama(addEntitasToMatpel.getNamaPelajaran());
        List<Entitas> entitas = new ArrayList<>();
        addEntitasToMatpel.getEntitas().stream().forEach(en -> {
            Entitas newEn = entitasService.getById(en);
            for (Role rol : newEn.getUser().getRoles()) {
                if (rol.getName().equals("siswa")) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Entitas tidak boleh selain guru");
                }
            }
            entitas.add(newEn);
        });

        List<MataPelajaran> mataPelajarans = new ArrayList<>();
        mataPelajarans.add(mataPelajaran);
        entitas.stream().forEach(ent -> ent.setMataPelajarans(mataPelajarans));
        mataPelajaran.setEntitas(entitas);

        return matapelajaranRepository.save(mataPelajaran);
    }

    public MataPelajaran updateEntitasToMatpel(Long id, AddEntitasToMatpel addEntitasToMatpel) {
        MataPelajaran mataPelajaran = getById(id);
        mataPelajaran.setNama(addEntitasToMatpel.getNamaPelajaran());
        List<Entitas> entitas = new ArrayList<>();
        mataPelajaran.setEntitas(entitas);
        addEntitasToMatpel.getEntitas().stream().forEach(en -> {
            Entitas newEn = entitasService.getById(en);
            for (Role rol : newEn.getUser().getRoles()) {
                if (rol.getName().equals("siswa")) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Entitas tidak boleh selain guru");
                }
            }
            entitas.add(newEn);
        });

        List<MataPelajaran> mataPelajarans = new ArrayList<>();
        mataPelajarans.add(mataPelajaran);
        entitas.stream().forEach(ent -> ent.setMataPelajarans(mataPelajarans));
        mataPelajaran.setEntitas(entitas);

        return matapelajaranRepository.save(mataPelajaran);
    }

}
