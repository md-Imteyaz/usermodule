package com.Users.Service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Users.Entity.UserTable;
@Service
@Component
public interface UserService{
	public List<UserTable> getAllUsers();

	public UserTable getUserById(int id);

	public UserTable addorUpdateUser(UserTable user);

	public UserTable deleteUser(int id) throws Exception;
	

}
