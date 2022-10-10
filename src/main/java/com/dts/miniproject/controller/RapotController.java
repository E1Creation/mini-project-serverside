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

import com.dts.miniproject.model.Rapot;
import com.dts.miniproject.model.dto.response.EntitasRapot;
import com.dts.miniproject.service.RapotService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/rapot")
public class RapotController {
    private RapotService rapotService;

    @GetMapping
    public ResponseEntity<List<Rapot>> getAll() {
        return new ResponseEntity<List<Rapot>>(rapotService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rapot> getById(@PathVariable Long id) {
        return new ResponseEntity<Rapot>(rapotService.getById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Rapot> create(@RequestBody Rapot rapot) {
        return new ResponseEntity<Rapot>(rapotService.create(rapot), HttpStatus.CREATED);
    }

    @GetMapping("/entitas/{id}")
    public ResponseEntity<EntitasRapot> getEntitasRapotByid(@PathVariable Long id) {
        return new ResponseEntity<EntitasRapot>(rapotService.getEntitasRapotByid(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rapot> update(@PathVariable Long id, @RequestBody Rapot rapot) {
        return new ResponseEntity<Rapot>(rapotService.update(id, rapot), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rapot> delete(@PathVariable Long id) {
        return new ResponseEntity<Rapot>(rapotService.delete(id), HttpStatus.OK);
    }

}
