package com.blog.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	@JsonProperty
	private Integer id;

	@JsonProperty
	@Size(min = 4,message = "User name must be 4 letter or greater")
	private String name;
	
	@JsonProperty
	@NotNull
	@Email(message = "Email address is not valid")
	private String email;

	@JsonProperty
	@NotNull
	@Size(min = 5, max= 10, message = "password character min 5 and max 10")
	private String password;
	
	@JsonProperty
	@NotNull
	private String about;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
