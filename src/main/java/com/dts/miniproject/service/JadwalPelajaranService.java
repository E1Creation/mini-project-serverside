package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.JadwalPelajaran;
import com.dts.miniproject.model.Kelas;
import com.dts.miniproject.model.MataPelajaran;
import com.dts.miniproject.model.dto.request.AddKelasMatpelToJadwal;
import com.dts.miniproject.repository.JadwalPelajaranRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JadwalPelajaranService {
    private JadwalPelajaranRepository repository;
    private KelasService kelasService;
    private MataPelajaranService mataPelajaranService;

    public List<JadwalPelajaran> getAll() {
        return repository.findAll();
    }

    public JadwalPelajaran getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Data JadwalPelajaran tidak ditemukan"));
    }

    public JadwalPelajaran create(JadwalPelajaran JadwalPelajaran) {
        if (JadwalPelajaran.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id JadwalPelajaran tidak ditemukan");
        }
        return repository.save(JadwalPelajaran);
    }

    public JadwalPelajaran update(Long id, JadwalPelajaran JadwalPelajaran) {
        JadwalPelajaran oldJadwalPelajaran = getById(id);
        if (oldJadwalPelajaran.getId() == JadwalPelajaran.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama JadwalPelajaran sama");
        }
        JadwalPelajaran.setId(id);
        return repository.save(JadwalPelajaran);
    }

    public JadwalPelajaran delete(Long id) {
        JadwalPelajaran JadwalPelajaran = getById(id);
        repository.delete(JadwalPelajaran);
        return JadwalPelajaran;
    }

    public JadwalPelajaran addKelasMatpelToJadwal(JadwalPelajaran jadwalPelajaran) {
        Kelas kelas = kelasService.getById(jadwalPelajaran.getKelas().getId());
        MataPelajaran mataPelajaran = mataPelajaranService.getById(jadwalPelajaran.getMataPelajarans().getId());
        jadwalPelajaran.setKelas(kelas);
        jadwalPelajaran.setMataPelajarans(mataPelajaran);

        return repository.save(jadwalPelajaran);

    }
}
