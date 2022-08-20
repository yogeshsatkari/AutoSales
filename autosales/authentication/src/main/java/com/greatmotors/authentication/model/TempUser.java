package com.greatmotors.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TempUser {
    private String userName, emailId, password;
    private UserRole role;
}
