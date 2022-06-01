package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.models.CategoryDto;
import com.blog.response.CommonControllerResponse;
import com.blog.response.GlobalUtils;
import com.blog.serviceImpl.CategoryServcieImpl;


@Valid
@RestController
@RequestMapping(GlobalUtils.GlobalPAth.category)
public class CategoryController {

	@Autowired
	private CategoryServcieImpl service;

	@GetMapping(GlobalUtils.GlobalPAth.category)
	public CommonControllerResponse<List<CategoryDto>> fetchAllPaginatedAndSortedRow(){
		return service.getAllCategoryByPaginationAndSorted();
	}
	
	@PostMapping(GlobalUtils.GlobalPAth.category)
	public CommonControllerResponse<CategoryDto> insertCategory(@Valid @RequestBody CategoryDto dto){
		return service.insertCategory(dto);
	}
	
	@PutMapping(GlobalUtils.GlobalPAth.updateCategory)
	public CommonControllerResponse<CategoryDto> updateOrSaveCategory(@Valid @RequestBody CategoryDto dto){
		return service.updateCategory(dto);
	}		
	
	@GetMapping(GlobalUtils.GlobalPAth.categoryById)
	public CommonControllerResponse<CategoryDto> findCategoryByid(@PathVariable Integer id){
		return service.getCategoryById(id);
	}
	
	@GetMapping(GlobalUtils.GlobalPAth.categoryByTitle)
	public CommonControllerResponse<List<CategoryDto>> findCategoryByTitle(@RequestParam String title){
		return service.getCategoryByTittle(title);
	}
	
	@PostMapping(GlobalUtils.GlobalPAth.insertAll)
	public CommonControllerResponse<List<CategoryDto>> insertAll(@RequestBody List<CategoryDto> dto){
		return service.insertAll(dto);
	}

	@DeleteMapping(GlobalUtils.GlobalPAth.deleteById)
	public CommonControllerResponse<Boolean> deleteUser(@PathVariable List<Integer> id) {
		return service.deleteById(id);
	}
	

	
	
}
