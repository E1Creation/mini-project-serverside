package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.repository.RoleRepository;
import com.dts.miniproject.service.generic.GenericService;
import com.dts.miniproject.model.Role;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoleService extends GenericService<Role> {
    private RoleRepository repository;

    // public List<Role> getAll() {
    // return repository.findAll();
    // }

    public Role insert(Role role) {
        if (role.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role already exist");
        }
        validateByName(role.getName());
        // List<User> users = new ArrayList<>();
        // role.getUsers().forEach((user) -> {
        // userService.insert(user);
        // });
        // users.addAll(role.getUsers());

        // role.setUsers(role.getUsers());
        return repository.save(role);
    }

    // public Role getById(Long id) {
    // // TODO Auto-generated method stub
    // // if (!repository.findById(id).isPresent()) {
    // // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role Not
    // Found!");
    // // }
    // return repository.findById(id)
    // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role
    // Not Found!"));
    // }

    public Role update(Long id, Role role) {
        Role oldRole = getById(id);
        if (!oldRole.getId().equals(role.getId())) {
            validateByName(role.getName());
        }
        role.setId(id);
        return repository.save(role);
    }

    // public Role delete(Long id) {
    // // TODO Auto-generated method stub
    // Role role = getById(id);
    // repository.deleteById(id);
    // return role;
    // }

    public void checkByName(String name) {
        getAll().forEach((reg) -> {
            if (reg.getName().equals(name)) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Role Name Already Exist");
            }
        });
    }

    public void validateByName(String name) {
        if (repository.existsByName(name)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role Name Already Exist");
        }
    }

    public Role findByName(String name) {
        if (!repository.findByName(name).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role already exists");
        }
        return repository.findByName(name).get();
    }
}
