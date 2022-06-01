package com.blog.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.entities.BlogCategory;
import com.blog.models.CategoryDto;
import com.blog.repositiory.CategoryRepository;
import com.blog.response.CommonControllerResponse;
import com.blog.service.CategoryService;


@Service
public class CategoryServcieImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CommonControllerResponse<List<CategoryDto>> getAllCategoryByPaginationAndSorted() {
		CommonControllerResponse<List<CategoryDto>> res = new CommonControllerResponse<>();
		List<BlogCategory> list = repo.findAll();
		List<CategoryDto> listDto = list.stream().map((data) -> categoryToDto(data)).collect(Collectors.toList());
		res.setData(listDto);
		res.setStatusCode(HttpStatus.ACCEPTED);
		res.setMessage("Details of category");

		return res;
	}

	@Override
	public CommonControllerResponse<CategoryDto> insertCategory(CategoryDto dto) {
		CommonControllerResponse<CategoryDto> res = new CommonControllerResponse<>();
		if (dto != null) {
			BlogCategory obj = repo.save(dtoToCategory(dto));
			CategoryDto dtoOBj = categoryToDto(obj);
			res.setData(dtoOBj);
			res.setStatusCode(HttpStatus.OK);
			res.setMessage("Data insert successfully");
		} else {
			res.setStatusCode(HttpStatus.FORBIDDEN);
		}
		return res;
	}

	@Override
	public CommonControllerResponse<CategoryDto> updateCategory(CategoryDto dto) {
		CommonControllerResponse<CategoryDto> res = new CommonControllerResponse<>();
		if (dto.getId() > 0) {
			BlogCategory category = repo.findById(dto.getId()).get();
			category.setCategoryDescription(dto.getCategoryDescription());
			category.setCategoryTitle(dto.getCategoryTitle());
			res.setData(categoryToDto(repo.save(category)));
			res.setMessage("data updated successfully");
			res.setStatusCode(HttpStatus.OK);
			return res;

		} else {
			return this.insertCategory(dto);
		}
	}

	@Override
	public CommonControllerResponse<CategoryDto> getCategoryById(Integer id) {
		CommonControllerResponse<CategoryDto> res = new CommonControllerResponse<>();
		BlogCategory obj = repo.findById(id).get();
		res.setData(categoryToDto(obj));
		res.setMessage("category details by id");
		return res;
	}

	@Override
	public CommonControllerResponse<List<CategoryDto>> getCategoryByTittle(String title) {
		CommonControllerResponse<List<CategoryDto>> res = new CommonControllerResponse<>();
		CommonControllerResponse<List<CategoryDto>> response = this.getAllCategoryByPaginationAndSorted();
		List<CategoryDto> list = response.getData();
		List<CategoryDto> newList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCategoryTitle().equalsIgnoreCase(title)) {
				BlogCategory category = new BlogCategory();
				category.setId(list.get(i).getId());
				category.setCategoryTitle(list.get(i).getCategoryTitle());
				category.setCategoryDescription(list.get(i).getCategoryDescription());
				newList.add(categoryToDto(category));
			}
		}
		res.setData(newList);
		res.setMessage("data by category title");
		return res;
	}

	@Override
	public CommonControllerResponse<Boolean> deleteById(List<Integer> id) {
		CommonControllerResponse<Boolean> res = new CommonControllerResponse<>();
		repo.deleteAllByIdInBatch(id);
		res.setData(true);
		res.setMessage("Selected ids data deleted");
		return res;
	}

	@Override
	public CommonControllerResponse<List<CategoryDto>> insertAll(List<CategoryDto> dto) {
		CommonControllerResponse<List<CategoryDto>> res = new CommonControllerResponse<>();
		List<BlogCategory> list = new ArrayList<>();
		List<CategoryDto> newList = new ArrayList<>();
		List<BlogCategory> savingdata = null ;

		for (int i = 0; i < dto.size(); i++) {
			CategoryDto dto1 = new CategoryDto();
			dto1.setCategoryTitle(dto.get(i).getCategoryTitle());
			dto1.setCategoryDescription(dto.get(i).getCategoryDescription());
			BlogCategory blog = dtoToCategory(dto1);
			list.add(blog);
			 savingdata = repo.saveAll(list);
		}
			if (savingdata != null) {
				for (int j = 0; j < savingdata.size(); j++) {
					System.out.println("========?"+savingdata.size());
					CategoryDto categoryDto = new CategoryDto();
					categoryDto.setId(savingdata.get(j).getId());
					categoryDto.setCategoryTitle(savingdata.get(j).getCategoryTitle());
					categoryDto.setCategoryDescription(savingdata.get(j).getCategoryDescription());
					newList.add(categoryDto);
				}
			}
			res.setData(newList);
			res.setMessage("All data insert succesfully");
			return res;
		}
		
	

	public BlogCategory dtoToCategory(CategoryDto dto) {
		return this.mapper.map(dto, BlogCategory.class);
	}

	public CategoryDto categoryToDto(BlogCategory category) {
		return this.mapper.map(category, CategoryDto.class);
	}

}
