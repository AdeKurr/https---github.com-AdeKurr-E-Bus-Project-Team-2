// package com.project.ebus.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.project.ebus.repository.userRepository;

// import java.util.List;

// import com.project.ebus.model.user;

// @Service
// public class UserService {

//     @Autowired
//     userRepository repo;

//     public user login(String email, String password) {
//         List<user> user = repo.findByEmailAndPassword(email, password);
//         return user;
//     }

//     public void save(user savedatauser) {
//         this.repo.save(savedatauser);
//     }
// }
