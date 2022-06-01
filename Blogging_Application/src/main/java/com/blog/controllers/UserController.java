package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.User;
import com.blog.models.UserDto;
import com.blog.response.CommonControllerResponse;
import com.blog.response.GlobalUtils;
import com.blog.service.UserService;

@RestController
@RequestMapping(GlobalUtils.GlobalPAth.user)
@Valid
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(GlobalUtils.GlobalPAth.user)
	public CommonControllerResponse<List<UserDto>> getAllUser() {
		return service.getAllUserByPaginationAndSorted();
	}

	@GetMapping(GlobalUtils.GlobalPAth.findById)
	public CommonControllerResponse<UserDto> getUserById(@PathVariable Integer id) {
		return service.getUserById(id);
	}

	@PostMapping(GlobalUtils.GlobalPAth.user)
	public CommonControllerResponse<UserDto> insertUser(@Valid @RequestBody UserDto dto) {
		return service.insertUser(dto);
	}
	
	@PostMapping(GlobalUtils.GlobalPAth.insertAll)
	public CommonControllerResponse<List<User>> insertAllUser(@Valid @RequestBody List<User> User) {
		return service.insertAll(User);
	}

	@PutMapping(GlobalUtils.GlobalPAth.update)
	public CommonControllerResponse<UserDto> updateUser(@Valid @PathVariable Integer id, @RequestBody UserDto dto) {
		return service.updateUser(id, dto);
	}
	
	@DeleteMapping(GlobalUtils.GlobalPAth.deleteById)
	public CommonControllerResponse<UserDto> deleteUser(@PathVariable List<Integer> id) {
		return service.deleteById(id);
	}
	

}
