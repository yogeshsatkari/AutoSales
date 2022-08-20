package com.greatmotors.UserAutomobiles.controller;

import com.greatmotors.UserAutomobiles.model.TempVehicle;
import com.greatmotors.UserAutomobiles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/auto")
public class UserController {

    @Autowired
    UserService userService;

    // http://localhost:8086/auto/getallusers/                [get]
    @GetMapping("/getallusers")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    // http://localhost:8086/auto/adduserimage/                [post]
    @PostMapping("/updateuserprofile")
    public ResponseEntity<?> updateUserProfile(@RequestParam("emailid")  String emailid, @RequestParam("username")  String username, @RequestParam("file") MultipartFile file) throws  IOException {
        try {
            return new ResponseEntity<>(userService.updateUserProfile(emailid,username,file), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("file IOException thrown", HttpStatus.OK);
        }
    }


    //  CART METHODS
    // http://localhost:8086/auto/addtocart/a@a.com                [put]
    @PutMapping("/addtocart/{emailId}")
    public ResponseEntity<?> addToCart(@PathVariable String emailId, @RequestBody TempVehicle tempVehicle) {
        return new ResponseEntity<>(userService.addToCart(emailId,tempVehicle), HttpStatus.OK);
    }


    // http://localhost:8086/auto/deletefromcart/a@a.com/{modelName}           [put]
    @PutMapping("/deletefromcart/{emailId}/{modelName}")
    public ResponseEntity<?> deleteFromCart(@PathVariable String emailId, @PathVariable String modelName) {
        return new ResponseEntity<>(userService.deleteFromCart(emailId,modelName), HttpStatus.OK);
    }


    // http://localhost:8086/auto/getfromcart/a@a.com/                [get]
    @GetMapping("/getfromcart/{emailId}")
    public ResponseEntity<?> getFromCart(@PathVariable String emailId) {
        return new ResponseEntity<>(userService.getFromCart(emailId), HttpStatus.OK);
    }








    //    // http://localhost:8086/auto/register              [post]
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
//    }


}
