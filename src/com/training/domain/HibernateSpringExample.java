package com.training.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.training.entity.Student;
import com.training.ifaces.MyDAO;


public class HibernateSpringExample extends HibernateDaoSupport implements MyDAO<Student> {

	@Override
	public Serializable add(Student t) {
	
		Serializable key = getHibernateTemplate().save(t);
		return key;
	}

	@Override
	public Student find(Serializable obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		List<Student> results = (List<Student>)getHibernateTemplate().find("from students"); 
		return results;
	}

	@Override
	public boolean update(Student obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Serializable obj) {
		return false;
	}

	
	

}
