package com.dts.miniproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dts.miniproject.model.JadwalPelajaran;
import com.dts.miniproject.model.Kelas;
import com.dts.miniproject.model.MataPelajaran;
import com.dts.miniproject.model.dto.mapper.Mapper;
import com.dts.miniproject.model.dto.request.AddKelasMatpelToJadwal;
import com.dts.miniproject.service.JadwalPelajaranService;
import com.dts.miniproject.service.KelasService;
import com.dts.miniproject.service.MataPelajaranService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/jadwalpelajaran")
public class JadwalPelajaranController {
    private JadwalPelajaranService jadwalPelajaranService;
    private KelasService kelasService;
    private MataPelajaranService mataPelajaranService;

    @GetMapping
    public ResponseEntity<List<JadwalPelajaran>> getAll() {
        return new ResponseEntity<List<JadwalPelajaran>>(jadwalPelajaranService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JadwalPelajaran> getById(@PathVariable Long id) {
        return new ResponseEntity<JadwalPelajaran>(jadwalPelajaranService.getById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<JadwalPelajaran> create(@RequestBody JadwalPelajaran JadwalPelajaran) {
        return new ResponseEntity<JadwalPelajaran>(jadwalPelajaranService.create(JadwalPelajaran), HttpStatus.CREATED);
    }

    @PostMapping("/kelasmatpel")
    public ResponseEntity<JadwalPelajaran> createDTO(@RequestBody AddKelasMatpelToJadwal addKelasMatpelToJadwal) {
        Kelas kelas = kelasService.getById(addKelasMatpelToJadwal.getIdKelas());
        MataPelajaran mataPelajaran = mataPelajaranService.getById(addKelasMatpelToJadwal.getIdMatpel());
        JadwalPelajaran jadwalPelajaran = Mapper.toJadwalPelajaran(addKelasMatpelToJadwal);
        jadwalPelajaran.setKelas(kelas);
        jadwalPelajaran.setMataPelajarans(mataPelajaran);

        return new ResponseEntity<JadwalPelajaran>(
                jadwalPelajaranService.addKelasMatpelToJadwal(jadwalPelajaran),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JadwalPelajaran> update(@PathVariable Long id, @RequestBody JadwalPelajaran JadwalPelajaran) {
        return new ResponseEntity<JadwalPelajaran>(jadwalPelajaranService.update(id, JadwalPelajaran),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JadwalPelajaran> delete(@PathVariable Long id) {
        return new ResponseEntity<JadwalPelajaran>(jadwalPelajaranService.delete(id), HttpStatus.OK);
    }
}
