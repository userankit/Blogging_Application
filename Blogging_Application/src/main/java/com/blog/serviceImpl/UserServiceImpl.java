package com.blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.blog.entities.User;
import com.blog.globalExceptionHandler.GlobalExcptionHandler;
import com.blog.models.UserDto;
import com.blog.repositiory.UserRepository;
import com.blog.response.CommonControllerResponse;
import com.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommonControllerResponse<List<UserDto>> getAllUserByPaginationAndSorted() {
		CommonControllerResponse<List<UserDto>> res = new CommonControllerResponse<>();
		List<User> list = repo.findAll();

		// First method
		List<UserDto> newList = list.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		res.setMessage("User details..");
		res.setData(newList);

		return res;
	}

	@Override
	public CommonControllerResponse<UserDto> insertUser(UserDto dto) {
		CommonControllerResponse<UserDto> res = new CommonControllerResponse<>();
		User u = this.dtoToUser(dto);
		String name = dto.getName();
		boolean flag = false;
		List<UserDto> user = this.getAllUserByPaginationAndSorted().getData();
		for (int i = 0; i < user.size(); i++) {
			if (name.equalsIgnoreCase(user.get(i).getName())) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			res.setMessage("data already exists");
			res.setStatusCode(HttpStatus.ALREADY_REPORTED);
		} else if (u != null && flag == false) {
			dto = userToDto(repo.save(u));
			res.setMessage("Data insert Successfully");
			res.setData(dto);
		} else {
			res.setData(dto);
			res.setMessage("Data is null");
		}
		
		return res;
	}

	@Override
	public CommonControllerResponse<UserDto> updateUser(Integer id, UserDto dto) {
		CommonControllerResponse<UserDto> res = new CommonControllerResponse<>();
		User user = repo.findById(id).get();
		if (user != null) {
			user.setName(dto.getName());
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			user.setAbout(dto.getAbout());
			repo.save(user);
			res.setData(userToDto(user));
		} else {
			res.setMessage("data is not updated");
		}
		return res;
	}

	@Override
	public CommonControllerResponse<UserDto> getUserById(Integer id) {
		CommonControllerResponse<UserDto> res = new CommonControllerResponse<>();
		try {
			User user = repo.findById(id).get();
			if (user != null) {
				res.setData(this.userToDto(user));
			}
		} catch (Exception e) {
			String message = e.getMessage();
			throw new GlobalExcptionHandler("404", message, HttpStatus.NOT_FOUND);
		}
		return res;
	}

	// This method using model mapper transfer the data from one class to other
	// class with same parameter
	public User dtoToUser(UserDto userDto) {
		User obj = this.modelMapper.map(userDto, User.class);
		return obj;

	}

	public UserDto userToDto(User user) {
		UserDto obj = this.modelMapper.map(user, UserDto.class);
		return obj;
	}

	@Override
	public CommonControllerResponse<UserDto> deleteById(List<Integer> id) {
		CommonControllerResponse<UserDto> res = new CommonControllerResponse<>();
		repo.deleteAllByIdInBatch(id);
		res.setMessage("data deleted succesfully");
		return res;
	}

	@Override
	public CommonControllerResponse<List<User>> insertAll(List<User> dto) {
		CommonControllerResponse<List<User>> res = new CommonControllerResponse<>();
		List<User> list = repo.saveAll(dto);
		res.setData(list);
		return res;
	}

}
