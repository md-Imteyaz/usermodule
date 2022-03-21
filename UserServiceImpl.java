package com.Users.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Users.Entity.UserTable;
import com.Users.Repo.UserRepo;
import com.Users.Service.UserService;
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userrepo;

	@Override
	public List<UserTable> getAllUsers() {
		return (List<UserTable>) userrepo.findAll();

	}

	@Override
	public UserTable getUserById(int id) {
		return userrepo.findById(id).orElse(null);

	}

	@Override
	public UserTable addorUpdateUser(UserTable user) {
		return userrepo.save(user);

	}

	@Override
	public UserTable deleteUser(int id) throws Exception {
		UserTable deletedUser = null;
		try {
			deletedUser = userrepo.findById(id).orElse(null);
			if (deletedUser == null) {
				throw new Exception("user not availaible");
			} else {
				userrepo.deleteById(id);
			}

		} catch (Exception ex) {
			throw ex;
		}
		return deletedUser;
	}

}
