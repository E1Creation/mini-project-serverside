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

import com.dts.miniproject.model.Kelas;
import com.dts.miniproject.service.KelasService;

@RestController
@RequestMapping("/kelas")
public class KelasController {
    private KelasService kelasService;

    @GetMapping
    public ResponseEntity<List<Kelas>> getAll() {
        return new ResponseEntity<List<Kelas>>(kelasService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kelas> getById(@PathVariable Long id) {
        return new ResponseEntity<Kelas>(kelasService.getById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Kelas> create(@RequestBody Kelas kelas) {
        return new ResponseEntity<Kelas>(kelasService.create(kelas), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kelas> update(@PathVariable Long id, @RequestBody Kelas kelas) {
        return new ResponseEntity<Kelas>(kelasService.update(id, kelas), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kelas> delete(@PathVariable Long id) {
        return new ResponseEntity<Kelas>(kelasService.delete(id), HttpStatus.OK);
    }
}
