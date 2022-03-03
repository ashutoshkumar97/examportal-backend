package com.exam.service.impl;

import com.exam.exception.ExamPortalException;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws ExamPortalException {

        if (userRepository.existsByEmail(user.getUsername())) {
            throw new ExamPortalException("User already exists!!!");
        } else {
            //create user
            //extract all roles n then save it to db
            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }
            //add all the roles to user object
            user.getUserRoles().addAll(userRoles);
            //persist user to db n return it
            return userRepository.save(user);
        }

    }
}
