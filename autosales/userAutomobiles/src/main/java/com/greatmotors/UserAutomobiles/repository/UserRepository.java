package com.greatmotors.UserAutomobiles.repository;

import com.greatmotors.UserAutomobiles.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
