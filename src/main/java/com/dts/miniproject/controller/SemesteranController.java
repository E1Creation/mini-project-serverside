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

import com.dts.miniproject.model.Semesteran;
import com.dts.miniproject.service.SemesteranService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/semesteran")
public class SemesteranController {
    private SemesteranService semesteranService;

    @GetMapping
    public ResponseEntity<List<Semesteran>> getAll() {
        return new ResponseEntity<List<Semesteran>>(semesteranService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semesteran> getById(@PathVariable Long id) {
        return new ResponseEntity<Semesteran>(semesteranService.getById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Semesteran> create(@RequestBody Semesteran semesteran) {
        return new ResponseEntity<Semesteran>(semesteranService.create(semesteran), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semesteran> update(@PathVariable Long id, @RequestBody Semesteran semesteran) {
        return new ResponseEntity<Semesteran>(semesteranService.update(id, semesteran), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Semesteran> delete(@PathVariable Long id) {
        return new ResponseEntity<Semesteran>(semesteranService.delete(id), HttpStatus.OK);
    }

}
