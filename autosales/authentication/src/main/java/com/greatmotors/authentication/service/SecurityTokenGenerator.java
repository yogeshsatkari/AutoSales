package com.greatmotors.authentication.service;

import com.greatmotors.authentication.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
