package com.integervalue.app.dao;

import java.util.UUID;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.integervalue.app.model.IntegerValue;

@Repository
public class IntegerValueDaoImp implements IntegerValueDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public IntegerValue findBy(UUID id) {
		String queryString = "FROM IntegerValue WHERE id = :id";
		return (IntegerValue) sessionFactory.getCurrentSession()
								.createQuery(queryString)
								.setParameter("id", id)
								.uniqueResult();
	}

	@Override
	public IntegerValue save(IntegerValue integerValue) {
		return (IntegerValue) sessionFactory.getCurrentSession().save(integerValue);		
	}

}
