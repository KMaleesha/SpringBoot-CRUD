package com.loit.demo.service.impl;

import com.loit.demo.domain.User;
import com.loit.demo.repository.UserRepository;
import com.loit.demo.resource.UserResource;
import com.loit.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getByFirstName(String firstName) {

        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> getByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }


    @Override
    public User updateUser(UserResource userResource, int id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setFirstName(userResource.getFirstName());
            user.setLastName(userResource.getLastName());
            user.setEmail(userResource.getEmail());
            user.setAddress(userResource.getAddress());
            user.setMobileNumber(Integer.valueOf(userResource.getMobileNumber()));
            return userRepository.save(user);
        }else{
            return optionalUser.get();
        }
    }

    @Override
    public String deleteUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
            return "Your Record has been deleted";
        }else{
            return "Record not Found";
        }
    }

    @Override
    public List<User> searchByUser(String search) {
        if(search != null){
            return userRepository.findByUsersearch(search);
        }else{
            return userRepository.findAll();
        }
    }

}
