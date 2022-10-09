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

import com.dts.miniproject.model.Entitas;
import com.dts.miniproject.service.EntitasService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entitas")
public class EntitasController {
    private EntitasService entitasService;

    @GetMapping
    public ResponseEntity<List<Entitas>> getAll() {
        return new ResponseEntity<List<Entitas>>(entitasService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entitas> getById(@PathVariable Long id) {
        return new ResponseEntity<Entitas>(entitasService.getById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Entitas> create(@RequestBody Entitas entitas) {
        return new ResponseEntity<Entitas>(entitasService.create(entitas), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entitas> update(@PathVariable Long id, @RequestBody Entitas entitas) {
        return new ResponseEntity<Entitas>(entitasService.update(id, entitas), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entitas> delete(@PathVariable Long id) {
        return new ResponseEntity<Entitas>(entitasService.delete(id), HttpStatus.OK);
    }

}
