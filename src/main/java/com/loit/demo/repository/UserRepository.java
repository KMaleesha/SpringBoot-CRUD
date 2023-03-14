package com.loit.demo.repository;

import com.loit.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("from User where firstName =?1")
//    public List<User> findByFirstName(String firstName);

    @Query("select u from User u where u.firstName = ?1 and u.lastName=?2")
    public List<User> findByLastName(String lastName);

    @Query(value = "select all from user where first_name = :firstName",nativeQuery = true)
    public List<User> findByFirstName(@Param("firstName") String firstName);

    @Query("SELECT u FROM User u WHERE CONCAT(u.id, u.firstName )LIKE %?1%")
    public List<User> findByUsersearch(String search);


}



























