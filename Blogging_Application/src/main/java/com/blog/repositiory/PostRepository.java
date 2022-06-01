package com.blog.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.BlogCategory;
import com.blog.entities.Post;
import com.blog.entities.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(BlogCategory category);

}
