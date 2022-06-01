package com.blog.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.BlogCategory;

public interface CategoryRepository extends JpaRepository<BlogCategory, Integer> {

}
