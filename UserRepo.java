package com.Users.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Users.Entity.UserTable;
@Repository

public interface UserRepo extends JpaRepository<UserTable , Integer> {

}
