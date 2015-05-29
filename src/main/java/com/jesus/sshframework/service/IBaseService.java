package com.jesus.sshframework.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T, PK extends Serializable> {

	/**
	 * 根据ID获取实体对象.
	 * @param id
	 *            记录ID
	 * @return 实体对象
	 */
	public T get(PK id);
	
	/**
	 * 保存实体对象.
	 * 
	 * @param entity
	 *            对象
	 * @return ID
	 */
	public PK save(T entity);
	
	/**
	 * 得到所有对象.
	 * @return
	 */
	public List<T> getAll();
	
	/***
	 * 删除
	 * @param id	记录
	 * @return	Id
	 */
	public void delete(PK id);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public long getCount();
}
