package com.jesus.sshframework.service.impl;

import java.io.Serializable;
import java.util.List;

import com.jesus.sshframework.dao.IBaseDao;
import com.jesus.sshframework.service.IBaseService;

public class BaseServiceImpl<T, PK extends Serializable> implements IBaseService<T, PK>{

	private IBaseDao<T, PK> baseDao;
	
	public IBaseDao<T, PK> getBaseDao() {
		return baseDao;
	}
	
	public void setBaseDao(IBaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public T get(PK id) {
		return baseDao.get(id);
	}

	@Override
	public PK save(T entity) {
		return baseDao.save(entity);
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll();
	}
	
	@Override
	public void delete(PK id) {
		baseDao.delete(id);
	}
	
	@Override
	public long getCount() {
		return baseDao.getCount();
	}
}
