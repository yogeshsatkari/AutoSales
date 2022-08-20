package com.greatmotors.UserAutomobiles.service;

import com.greatmotors.UserAutomobiles.model.TempVehicle;
import com.greatmotors.UserAutomobiles.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User register(User user);
    List<User> getAllUsers();
    User addToCart(String emailId, TempVehicle tempVehicle);
    User deleteFromCart(String emailId, String modelName);
    List<TempVehicle> getFromCart(String emailId);
    User updateUserProfile(String emailId, String userName, MultipartFile multipartFile) throws IOException;

}
