package com.blog.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.entities.Post;
import com.blog.models.CategoryDto;
import com.blog.models.PostDto;
import com.blog.repositiory.PostRepository;
import com.blog.response.CommonControllerResponse;
import com.blog.service.BlogPostService;

public class PostServiceImpl implements BlogPostService{
	
	
	@Autowired
	private PostRepository repo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CommonControllerResponse<List<PostDto>> getAllPostByPaginationAndSorted() {
		
		
		return null;
	}

	@Override
	public CommonControllerResponse<PostDto> insertPost(PostDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonControllerResponse<PostDto> updatePost(PostDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonControllerResponse<PostDto> getPostById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonControllerResponse<List<PostDto>> getPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonControllerResponse<List<PostDto>> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonControllerResponse<List<PostDto>> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonControllerResponse<Boolean> deleteById(List<Integer> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonControllerResponse<List<PostDto>> insertAll(List<CategoryDto> dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Post dtoToPost(PostDto dto) {
		return mapper.map(dto, Post.class);
	}
	
	public PostDto postToDto(Post post) {
		return mapper.map(post, PostDto.class);
	}

}
