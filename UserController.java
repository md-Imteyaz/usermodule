package com.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Notes.Entity.Note;
import com.Users.Entity.UserTable;
import com.Users.Service.UserService;
import com.Users.Utility.UserServiceUtil;
import com.Users.Utility.UserServiceUtility;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceUtility userserviceutility;

	@Autowired
	private UserServiceUtil userserviceutil;

	@Autowired
	private UserService userservice1;

	@GetMapping("/alluser")
	public ResponseEntity<List<UserTable>> getAllUser() {
		List<UserTable> user = null;
		try {
			user = userservice1.getAllUsers();

		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<UserTable>>(user, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<UserTable> getNoteById(@PathVariable("id") int id) {
		UserTable user = null;
		try {
			user = userservice1.getUserById(id);

		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<UserTable>(user, HttpStatus.OK);
	}

	@PostMapping("/addorUpdate")
	public UserTable addorUpadate(@RequestBody UserTable user) {
		UserTable users = null;
		try {
			user = userservice1.addorUpdateUser(user);

		} catch (Exception ex) {
			ex.getMessage();
		}
		return  user ;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<UserTable> deleteId(@PathVariable("id") int id) {
		UserTable user = null;
		try {
			user = userservice1.deleteUser(id);

		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<UserTable>(user, HttpStatus.OK);
	}

	@GetMapping("/user-allnote")
	public List<Note> getAllNotes() {
		return userserviceutility.getAllNotes();
	}

	@GetMapping("/user-getNoteById/{id}")
	public void getNoteById1(int id) {
		 userserviceutility.getNoteById(id);
	}

	@PostMapping("/user-addorUpdatenote")
	public String addorUpadateNote(Note note) {
		return userserviceutility.addorUpadateNote(note);
	}

	@DeleteMapping("/user-delete/{id}")
	public String deleteid(int id) {
		return userserviceutility.deleteid(id);
	}

	@GetMapping("/user-alltask")
	public List getAllTasks() {
		return userserviceutil.getAllTasks();
	}

	@GetMapping("/user-getTaskById/{tId}")
	public int getTaskById() {
		return userserviceutil.getTaskById();
	}

	@PostMapping("/user-taskaddorUpadate")
	public String addorUpadateTask() {
		return userserviceutil.addorUpadateTask();
	}

	@DeleteMapping("/user-delete/{tId}")
	public String deleteId() {
		return userserviceutil.deleteId();
	}
}
