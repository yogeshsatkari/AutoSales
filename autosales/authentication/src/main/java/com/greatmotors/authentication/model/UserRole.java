package com.greatmotors.authentication.model;

public enum UserRole {
    ROLE_USER, ROLE_ADMIN       //If we add a new value in the middle or rearrange the enum's order, we'll break the existing data model.
}

//The JPA 2.1 release introduced a new standardized API that can be used to convert an entity attribute to a database value and vice versa.
//We should always use the AttributeConverter interface and @Converter annotation if we're using JPA 2.1 or later.