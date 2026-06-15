package com.immigration.system.entities;


import jakarta.persistence.MappedSuperclass;

/**
 * what will do ?
 1.Create an abstract class Person . (Do not use @Entity, only use  @MappedSuperclass so subclasses inherit these columns
 * without Person itself becoming a database table.
 * Fields:firstName (String),lastName (String),
 gender (String), phoneNumber (String), email (String).

 2. Implement standard constructors, getters, setters, and tostring() .

 */
@MappedSuperclass //
    public abstract class Person {

         //Declaring variables
        private String firstName;
        private String lastName;
        private String gender;
        private String phoneNumber;
        private String email;

}
