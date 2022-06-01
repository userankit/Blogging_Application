package com.blog.service;

import java.util.List;

import com.blog.entities.User;
import com.blog.models.UserDto;
import com.blog.response.CommonControllerResponse;

public interface UserService {

	public CommonControllerResponse<List<UserDto>> getAllUserByPaginationAndSorted();
	public CommonControllerResponse<UserDto> insertUser(UserDto dto);
	public CommonControllerResponse<UserDto> updateUser(Integer id, UserDto dto);
	public CommonControllerResponse<UserDto> getUserById(Integer id);
	public CommonControllerResponse<UserDto> deleteById(List<Integer> id);
	public CommonControllerResponse<List<User>> insertAll(List<User> dto);


	

}
