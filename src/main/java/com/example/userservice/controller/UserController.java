package com.example.userservice.controller;


import com.example.userservice.model.User;
import com.example.userservice.model.UserDto;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3005")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
//    @GetMapping("/users")
//    public ResponseEntity<List<UserDto>> getAllUser(@RequestParam(required = false) String firstName) {
//        try {
//            List<UserDto> users = new ArrayList<User>();
//            if (firstName == null)
//                userRepository.findAll().forEach(users::add);
//            else
//                userRepository.findByaddressContaining(firstName).forEach(users::add);
//            if (users.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(users, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userRepository.save(new User(user.getFirstName(),
                    user.getLastName(),
                    user.getMiddleName(),
                    user.getPhoneNumber(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getDateOfBirth(),
                    user.getGender(),
                    user.getPassword()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   

//    @GetMapping("/user")
//    public ResponseEntity<List<User>> getAllUser(@RequestParam(required = false) String dateOfBirth) {
//        try {
//            List<User> tutorials = new ArrayList<User>();
//            if (dateOfBirth == null)
//                userRepository.findAll().forEach(dateOfBirth::add);
//            else
//                userRepository.findBydateOfBirth(dateOfBirth).forEach(dateOfBirth::add);
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(dateOfBirth, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @GetMapping("/user/dateOfBirth")
//    public ResponseEntity<List<User>> findByPublished() {
//        try {
//            List<User> user = userRepository.findBydateOfBirth(@PathVariable("dateOfBirth") String);
//            if (user.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}







