package com.project.ebus.repository;

import com.project.ebus.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user, Long> {

    user findByEmailAndPassword(String email, String password);
}
