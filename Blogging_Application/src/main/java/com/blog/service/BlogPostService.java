package com.blog.service;

import java.util.List;

import com.blog.models.CategoryDto;
import com.blog.models.PostDto;
import com.blog.response.CommonControllerResponse;

public interface BlogPostService {
	
	public CommonControllerResponse<List<PostDto>> getAllPostByPaginationAndSorted();
	public CommonControllerResponse<PostDto> insertPost(PostDto dto);
	public CommonControllerResponse<PostDto> updatePost(PostDto dto);
	public CommonControllerResponse<PostDto> getPostById(Integer id);
	public CommonControllerResponse<List<PostDto>> getPostByCategory(Integer categoryId);
	public CommonControllerResponse<List<PostDto>> getPostByUser(Integer userId);
	public CommonControllerResponse<List<PostDto>> searchPost(String keyword);
	public CommonControllerResponse<Boolean> deleteById(List<Integer> id);
	public CommonControllerResponse<List<PostDto>> insertAll(List<CategoryDto> dto);

	

}
