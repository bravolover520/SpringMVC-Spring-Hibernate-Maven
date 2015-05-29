package com.jesus.sshframework.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.jesus.sshframework.dao.IBaseDao;

@Repository
public class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK>{	

	private Class<T> entityClass;
	protected SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = null;
		Class<?> c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		/***
		 * 注意：hibernate4不支持你用hibernate3的 getcurrentSession,建议你用openSession.
		 * 否则报：org.hibernate.HibernateException: No Session found for current thread错误.
		 */
//		return sessionFactory.getCurrentSession();
//		return sessionFactory.openSession();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			if (null == session || !session.isOpen())
				session = sessionFactory.openSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Assert.notNull(id, "id is required");
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public PK save(T entity) {
		Assert.notNull(entity, "entity is required");
		return (PK) getSession().save(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		String hql = "from " + entityClass.getName();
		return getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(PK id) {
		Assert.notNull(id, "id is required");
		T entity = (T) getSession().load(entityClass, id);
		getSession().delete(entity);
	}
	
	@Override
	public long getCount() {
		String hql = "select count(*) from " + entityClass.getName();
		return (long) getSession().createQuery(hql).uniqueResult();
	}

}
