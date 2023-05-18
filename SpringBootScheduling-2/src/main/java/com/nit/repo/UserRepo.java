package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
