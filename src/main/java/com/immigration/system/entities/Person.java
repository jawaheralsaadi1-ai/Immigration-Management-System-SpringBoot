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

   // Constructor
    public Person() {} //
    public Person(String firstName, String lastName, String gender,
                  String phoneNumber, String email) {
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.gender      = gender;
        this.phoneNumber = phoneNumber;
        this.email       = email;
    }
    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    // Setters


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


