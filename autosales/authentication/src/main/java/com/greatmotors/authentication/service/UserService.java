package com.greatmotors.authentication.service;

import com.greatmotors.authentication.exceptions.UserAlreadyExistsException;
import com.greatmotors.authentication.model.TempUser;
import com.greatmotors.authentication.model.User;

public interface UserService {
    User signUp(TempUser tempUser) throws UserAlreadyExistsException;
    User logIn(User user);
}
