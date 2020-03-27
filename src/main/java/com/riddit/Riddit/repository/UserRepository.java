package com.riddit.Riddit.repository;


import com.riddit.Riddit.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
