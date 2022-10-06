package io.ke.web.models;



import java.time.LocalDateTime;

//import java.time.LocalDateTime;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID id;

    private String emailId;

    private String password;
    private String createTime;
    private String updateTime;
    

    public User() {}

    public User(UUID id, String emailId, String password) {
        this.id = id;
        this.emailId = emailId;
        this.password = password;
        this.createTime=LocalDateTime.now().toString();                
        this.updateTime=LocalDateTime.now().toString();
    }
}

    // @Column(name = "create_time")
    // private String createTime;

    // @Column(name = "update_time")
    // private String updateTime;

    // public User(String email_address, String password, String first_name, String last_name, String create_time,
    //              String update_time ){
    //                 this.Email = email_address;
    //                 this.Password=password;
    //                 this.firstName=first_name;
    //                 this.lastName=last_name;
    //                 this.createTime=LocalDateTime.now().toString();
    //                 this.updateTime=LocalDateTime.now().toString();

                