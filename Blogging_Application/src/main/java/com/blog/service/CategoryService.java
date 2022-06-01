package com.blog.service;

import java.util.List;

import com.blog.entities.BlogCategory;
import com.blog.models.CategoryDto;
import com.blog.response.CommonControllerResponse;

public interface CategoryService {

	public CommonControllerResponse<List<CategoryDto>> getAllCategoryByPaginationAndSorted();
	public CommonControllerResponse<CategoryDto> insertCategory(CategoryDto dto);
	public CommonControllerResponse<CategoryDto> updateCategory(CategoryDto dto);
	public CommonControllerResponse<CategoryDto> getCategoryById(Integer id);
	public CommonControllerResponse<List<CategoryDto>> getCategoryByTittle(String title);
	public CommonControllerResponse<Boolean> deleteById(List<Integer> id);
	public CommonControllerResponse<List<CategoryDto>> insertAll(List<CategoryDto> dto);

}
