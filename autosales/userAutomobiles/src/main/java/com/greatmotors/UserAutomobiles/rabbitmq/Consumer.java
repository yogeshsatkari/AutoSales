package com.greatmotors.UserAutomobiles.rabbitmq;

import com.greatmotors.UserAutomobiles.model.User;
import com.greatmotors.UserAutomobiles.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Consumer {

    @Autowired
    private UserService userService;

    @RabbitListener(queues = "autosales_queue")
    public void getDtoAndAddToDb(UserDTO userDTO) {
        User user = new User();
        user.setEmailId(userDTO.getEmailId());
        user.setUserName(userDTO.getUserName());
        user.setCart(new ArrayList<>());
        userService.register(user);
    }
}
