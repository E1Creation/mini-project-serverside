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

import com.dts.miniproject.model.MataPelajaran;
import com.dts.miniproject.model.dto.request.AddEntitasToMatpel;
import com.dts.miniproject.service.MataPelajaranService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/matapelajaran")
public class MataPelajaranController {
    private MataPelajaranService matapelajaranService;

    @GetMapping
    public ResponseEntity<List<MataPelajaran>> getAll() {
        return new ResponseEntity<List<MataPelajaran>>(matapelajaranService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MataPelajaran> getById(@PathVariable Long id) {
        return new ResponseEntity<MataPelajaran>(matapelajaranService.getById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<MataPelajaran> create(@RequestBody MataPelajaran matapelajaran) {
        return new ResponseEntity<MataPelajaran>(matapelajaranService.create(matapelajaran), HttpStatus.CREATED);
    }

    @PostMapping("/entitas")
    public ResponseEntity<MataPelajaran> addEntitasToMatpel(@RequestBody AddEntitasToMatpel addeEntitasToMatpel) {
        return new ResponseEntity<MataPelajaran>(matapelajaranService.addEntitasToMatpel(addeEntitasToMatpel),
                HttpStatus.CREATED);
    }

    @PutMapping("/entitas/{id}")
    public ResponseEntity<MataPelajaran> updateEntitasToMatpel(@PathVariable Long id,
            @RequestBody AddEntitasToMatpel addeEntitasToMatpel) {
        return new ResponseEntity<MataPelajaran>(matapelajaranService.updateEntitasToMatpel(id, addeEntitasToMatpel),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MataPelajaran> update(@PathVariable Long id, @RequestBody MataPelajaran matapelajaran) {
        return new ResponseEntity<MataPelajaran>(matapelajaranService.update(id, matapelajaran), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MataPelajaran> delete(@PathVariable Long id) {
        return new ResponseEntity<MataPelajaran>(matapelajaranService.delete(id), HttpStatus.OK);
    }

}
