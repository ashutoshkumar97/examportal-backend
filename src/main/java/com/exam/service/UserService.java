package com.exam.service;

import com.exam.exception.ExamPortalException;
import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;

public interface UserService {

    //create user
    public User createUser(User user, Set<UserRole> userRoles) throws ExamPortalException;
}
