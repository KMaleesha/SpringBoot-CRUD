package com.loit.demo.service;

import com.loit.demo.domain.User;
import com.loit.demo.resource.UserResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public User saveUser(User user);

    public List<User> getAll();

    public Optional<User> getById(int id);

    public List<User> getByFirstName(String firstName);
    public List<User> getByLastName(String lastName);

    public User updateUser(UserResource userResource, int id);

    public String deleteUser(int id);

    public List<User> searchByUser(String search);
}