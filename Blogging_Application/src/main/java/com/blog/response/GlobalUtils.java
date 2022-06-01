package com.blog.response;

public  interface GlobalUtils {

	interface ExceptionCode{
		String success = "M200";
		String M404 = "404 data not found";
		
	}
	interface ResponseMessage{
		String success = "Success";
	}
	
	interface GlobalPAth{
		String user = "/user";
		String category = "/category";
		String categoryById = "/category/{id}";
		String categoryByTitle = "/category/title";
		String updateCategory = "/category";
		String insertAll = "/insertAll";
		String update = "user/{id}";
		String findById = "user/{id}";
		String deleteById = "/{id}";
		String backSlace = "/";
		String UPLOAD_DOCUMENT = "/documents";
		String FILE_UPLOAD = "/file";
	}
}
