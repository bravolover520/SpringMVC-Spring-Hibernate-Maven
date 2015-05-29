package com.jesus.sshframework.dao;

import java.io.Serializable;
import java.util.List;


/**
 * Dao接口 - Dao基接口
 */

public interface IBaseDao<T, PK extends Serializable> {

	/**
	 * 根据ID获取实体对象.
	 * 
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
	 * 获取全部对象.
	 * @return
	 */
	public List<T> getAll();
	
	/**
	 * 根据Id删除实体对象.
	 * @param id
	 *            记录ID
	 */
	public void delete(PK id);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public long getCount();
}