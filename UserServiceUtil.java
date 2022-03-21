package com.Users.Utility;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "task", url = "http://localhost:8151/task")

public interface UserServiceUtil {
	@GetMapping("/alltask")
	public List getAllTasks();

	@GetMapping("/getTaskById/{tId}")
	public int getTaskById();

	@PostMapping("/taskaddorUpdate")
	public String addorUpadateTask();

	@DeleteMapping("/delete/{tId}")
	public String deleteId();

}
