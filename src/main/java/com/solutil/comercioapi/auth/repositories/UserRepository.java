package com.solutil.comercioapi.auth.repositories;

import com.solutil.comercioapi.auth.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}