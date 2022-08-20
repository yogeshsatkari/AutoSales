package com.greatmotors.UserAutomobiles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor                       // used by User only.
@AllArgsConstructor
public class TempVehicle {
        private String modelName;
        private String company, description, imageUrl;
        private double price;
}
