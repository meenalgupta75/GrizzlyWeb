package com.cts.grizzly_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly_store.bean.Category;
import com.cts.grizzly_store.dao.CategoryDAO;

@Service("categoryService")
@Transactional(propagation=Propagation.SUPPORTS)
public class CategoryServiceImpl implements CategoryService {
@Autowired
CategoryDAO categoryDAO;

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getAllCategory();
	}

}
