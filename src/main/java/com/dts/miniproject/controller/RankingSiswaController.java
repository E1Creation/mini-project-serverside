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

import com.dts.miniproject.model.RankingSiswa;
import com.dts.miniproject.service.RankingSiswaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/rankingsiswa")
public class RankingSiswaController {
    private RankingSiswaService rankingsiswaService;

    @GetMapping
    public ResponseEntity<List<RankingSiswa>> getAll() {
        return new ResponseEntity<List<RankingSiswa>>(rankingsiswaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankingSiswa> getById(@PathVariable Long id) {
        return new ResponseEntity<RankingSiswa>(rankingsiswaService.getById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<RankingSiswa> create(@RequestBody RankingSiswa rankingsiswa) {
        return new ResponseEntity<RankingSiswa>(rankingsiswaService.create(rankingsiswa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RankingSiswa> update(@PathVariable Long id, @RequestBody RankingSiswa rankingsiswa) {
        return new ResponseEntity<RankingSiswa>(rankingsiswaService.update(id, rankingsiswa), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RankingSiswa> delete(@PathVariable Long id) {
        return new ResponseEntity<RankingSiswa>(rankingsiswaService.delete(id), HttpStatus.OK);
    }

}
