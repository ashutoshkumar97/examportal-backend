package com.exam.controller;

import com.exam.exception.ExamPortalException;
import com.exam.model.Role;
import com.exam.model.RoleType;
import com.exam.model.User;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    //creating user
    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) throws ExamPortalException {

        // set role
        Set<Role> strRoles = user.getRoles();
        Set<Role> roles = new HashSet<>();
        Role userRole = new Role();
        userRole.setRoleName(RoleType.ROLE_USER);
        Role role = roleRepository.save(userRole);
        roles.add(role);

        // Create new User Account
        user.setRoles(roles);

        User save = userRepository.save(user);

        return ResponseEntity.ok(save);
    }
}
