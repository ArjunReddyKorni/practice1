package com.jpa.practice1.repository;

import com.jpa.practice1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    List<User> findByFirstName(String firstName);

}
