package com.ianpan.blog_server.repository;


import com.ianpan.blog_server.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> { // type of entity and ID that it works with, User and Long

    List<User> findByLastName(String lastName);
    User findById(long id);
    User findByEmail(String email);


}
