package com.greatmotors.authentication.service;

import com.greatmotors.authentication.exceptions.UserAlreadyExistsException;
import com.greatmotors.authentication.model.TempUser;
import com.greatmotors.authentication.model.User;
import com.greatmotors.authentication.model.UserRole;
import com.greatmotors.authentication.rabbitmq.Producer;
import com.greatmotors.authentication.rabbitmq.UserDTO;
import com.greatmotors.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    Producer producer;

    @Override
    public User signUp(TempUser tempUser) throws UserAlreadyExistsException {
        tempUser.setRole(UserRole.ROLE_USER);
        if(userRepository.existsById(tempUser.getEmailId()) || tempUser.getPassword() == null){   // why null check not giving error?
            throw new UserAlreadyExistsException();
        }
        UserDTO userDTO = new UserDTO(tempUser.getUserName(),tempUser.getEmailId());
        producer.sendMessageToMq(userDTO);      //sending userDTO to queue
        User user = new User(tempUser.getEmailId(), tempUser.getPassword(), tempUser.getRole());
        return userRepository.save(user);       //sending user to mysql user table
    }

    @Override
    public User logIn(User user) {
        User user1 = userRepository.findUserByEmailIdAndPassword(user.getEmailId(), user.getPassword());
        if(user1!=null){
            return user1;
        }
        return null;
    }
}
