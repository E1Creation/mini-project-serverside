package com.dts.miniproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dts.miniproject.model.Role;
import com.dts.miniproject.model.User;
import com.dts.miniproject.model.dto.request.AddRoleUserRequest;
import com.dts.miniproject.repository.UserRepository;
import com.dts.miniproject.service.generic.GenericService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService extends GenericService<User> {

    private UserRepository repository;
    private RoleService roleService;

    // public List<User> getAll() {
    // return repository.findAll();
    // }

    public User insert(User user) {
        if (user.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "user already exist");
        }
        validateByName(user.getUsername());
        return repository.save(user);
    }

    // public User getById(Long id) {
    // // TODO Auto-generated method stub
    // // if (!repository.findById(id).isPresent()) {
    // // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not
    // Found!");
    // // }
    // return repository.findById(id)
    // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User
    // Not Found!"));
    // }

    public User update(Long id, User user) {
        User oldUser = getById(id);
        if (!oldUser.getId().equals(user.getId())) {
            validateByName(user.getUsername());
        }
        user.setId(id);
        return repository.save(user);
    }

    // public User delete(Long id) {
    // // TODO Auto-generated method stub
    // User user = getById(id);
    // repository.deleteById(id);
    // return user;
    // }

    public void checkByName(String name) {
        getAll().forEach((reg) -> {
            if (reg.getUsername().equals(name)) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "User Name Already Exist");
            }
        });
    }

    public void findByName(String name) {
        if (repository.findByUsername(name).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }
    }

    public void validateByName(String name) {
        if (repository.existsByUsername(name)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Name Already Exist");
        }
    }

    public User addRole(AddRoleUserRequest addRoleUserRequest) {
        User user = getById(addRoleUserRequest.getUserId());
        List<Role> roles = user.getRoles();
        addRoleUserRequest.getRoles().forEach(role -> {
            roles.add(roleService.findByName(role));
        });
        user.setRoles(roles);
        return repository.save(user);
    }

    public User updateRole(AddRoleUserRequest addRoleUserRequest) {
        User user = getById(addRoleUserRequest.getUserId());
        List<Role> roles = user.getRoles();
        roles.clear();
        addRoleUserRequest.getRoles().forEach(role -> {
            roles.add(roleService.findByName(role));
        });
        user.setRoles(roles);
        return repository.save(user);
    }

}
