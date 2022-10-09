package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.RankingSiswa;
import com.dts.miniproject.repository.RankingSiswaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RankingSiswaService {
    private RankingSiswaRepository repository;

    public List<RankingSiswa> getAll() {
        return repository.findAll();
    }

    public RankingSiswa getById(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data RankingSiswa tidak ditemukan"));
    }

    public RankingSiswa create(RankingSiswa rankingsiswa) {
        if (rankingsiswa.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id RankingSiswa tidak ditemukan");
        }
        validateByRank(rankingsiswa.getRank());
        return repository.save(rankingsiswa);
    }

    public RankingSiswa update(Long id, RankingSiswa rankingsiswa) {
        RankingSiswa oldRankingSiswa = getById(id);
        if (oldRankingSiswa.getId() == rankingsiswa.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama RankingSiswa sama");
        }
        rankingsiswa.setId(id);
        return repository.save(rankingsiswa);
    }

    public RankingSiswa delete(Long id) {
        RankingSiswa rankingsiswa = getById(id);
        repository.delete(rankingsiswa);
        return rankingsiswa;
    }

    public void validateByRank(int rank) {
        if (repository.existsByRank(rank)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama RankingSiswa sudah ada");
        }

    }
}