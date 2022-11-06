package com.dts.miniproject.service.generic;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.BaseEntity;
import com.dts.miniproject.repository.generic.GenericRepository;

@MappedSuperclass
public class GenericService<T extends BaseEntity> {
    @Autowired
    protected GenericRepository<T> genericRepository;

    public List<T> getAll() {
        System.out.println();
        return genericRepository.findAll();
    }

    public T getById(Long id) {
        return genericRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Rapot tidak ditemukan"));
    }

    // public T create(T T) {
    // if (T.getId() != null) {
    // throw new ResponseStatusException(HttpStatus.CONFLICT, "Id T tidak
    // ditemukan");
    // }
    // return genericRepository.save(T);
    // }

    // public T update(Long id, T T) {
    // T oldT = getById(id);
    // if (oldT.getId() == T.getId()) {
    // throw new ResponseStatusException(HttpStatus.CONFLICT, "Nama T sama");
    // }
    // T.setId(id);
    // return genericRepository.save(T);
    // }

    public T delete(Long id) {
        T t = getById(id);
        genericRepository.delete(t);
        return t;
    }
}
