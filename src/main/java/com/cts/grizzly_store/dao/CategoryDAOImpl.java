package com.cts.grizzly_store.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly_store.bean.Category;
import com.cts.grizzly_store.bean.Login;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired

	 private SessionFactory sessionFacotry;

	@Override
	public List<Category> getAllCategory() {
		Session session=null;
		String query="from Category";
		org.hibernate.query.Query<Category> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		List<Category> list=query2.getResultList();
		System.out.println(list);
		return list;
	}

}
