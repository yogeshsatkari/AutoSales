package com.greatmotors.authentication.repository;

import com.greatmotors.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
     User findUserByEmailIdAndPassword(String emailId, String password);
}
