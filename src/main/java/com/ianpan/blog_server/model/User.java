package com.ianpan.blog_server.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // JPA entity, map to
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String shortName;
    private String gender; //TODO: Make this enum and study how to interact with enun in JPA
    private String email;

    protected User(){} //The default constructor exists only for the sake of JPA.
                            //The other constructor is the one you use to create instances of Customer to be saved to the database.


    public User(String firstName, String lastName, String email, String shortName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.shortName = shortName;
        this.gender = gender;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d], firstName = '%s', lastname = '%s', email = '%s', shortname = '%s', gender = '%s']", id,firstName,lastName, email, shortName, gender);
    }
    public Long getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){return email; }
    public String getShortName() { return shortName; }
    public String getGender() { return gender;}

}
