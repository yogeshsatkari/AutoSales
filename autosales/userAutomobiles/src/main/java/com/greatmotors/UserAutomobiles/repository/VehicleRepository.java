package com.greatmotors.UserAutomobiles.repository;

import com.greatmotors.UserAutomobiles.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository <Vehicle, String> {
}
