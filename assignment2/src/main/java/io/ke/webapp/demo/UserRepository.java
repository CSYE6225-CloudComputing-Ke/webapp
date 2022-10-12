/*
 * @Author: ke 
 * @Date: 2022-10-06 10:40:46 
 * @Last Modified by: ke
 * @Last Modified time: 2022-10-06 12:06:04
 */
package io.ke.webapp.demo;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);


}

