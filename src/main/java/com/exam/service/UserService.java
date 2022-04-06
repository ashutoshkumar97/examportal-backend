package com.exam.service;

import com.exam.exception.ExamPortalException;
import com.exam.model.User;

import java.util.Set;

public interface UserService {

    //create user
    public User createUser(User user) throws ExamPortalException;
}
