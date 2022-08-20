package com.greatmotors.UserAutomobiles.service;

import com.greatmotors.UserAutomobiles.model.TempVehicle;
import com.greatmotors.UserAutomobiles.model.User;
import com.greatmotors.UserAutomobiles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {                       // for admin access only
        return userRepository.findAll();
    }

    @Override
    public User updateUserProfile(String emailId, String userName, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename() ;
        User user = userRepository.findById(emailId).get();
        if(fileName.contains("..")) {
            System.out.println("Not a valid file");
        }
        user.setUserName(userName);
        user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return userRepository.save(user);
    }



    // custom method in repository can be made for below methods

    @Override
    public User addToCart(String emailId, TempVehicle tempVehicle) {
        User user = userRepository.findById(emailId).get();             //no such exception, if not user is present.
        user.getCart().add(tempVehicle);
        return userRepository.save(user);
    }

    @Override
    public User deleteFromCart(String emailId, String modelName) {
        User user = userRepository.findById(emailId).get();                    //no such exception, if not user is present.
        user.getCart().removeIf(tv -> tv.getModelName().equals(modelName));

        // set his cart again, if vehicle not deleted,
        return userRepository.save(user);
    }

    @Override
    public List<TempVehicle> getFromCart(String emailId) {
        return userRepository.findById(emailId).get().getCart();
    }


}
