/*
 * @Author: ke 
 * @Date: 2022-10-06 10:40:37 
 * @Last Modified by:   ke 
 * @Last Modified time: 2022-10-06 10:40:37 
 */
package io.ke.webapp.demo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity // Hibernate 

public class User {


    private String password;
    private String id;

//    private String token;

    @Id
    private String email;

    private String token;

    private String  first_name;
    private String  last_name;
    private String create_time;
    private String update_time;

    


    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

