package com.jesus.sshframework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jesus.sshframework.dao.IUserDao;
import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, String> implements IUserService{

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	/**
	 * (1).@Autowired 与@Resource都可以用来装配bean. 都可以写在字段上,或写在setter方法上;
	 * (2).@Autowired 默认按类型装配，默认情况下必须要求依赖对象必须存在，如果要允许null值，
	 * 可以设置它的required属性为false，如：@Autowired(required=false).如果我们想使用名称装配可以结合  .@Qualifier注解进行使用;
	 * (3).@Resource（这个注解属于J2EE的），默认安装名称进行装配，名称可以通过name属性进行指定，如果没有指定name属性，
	 * 当注解写在字段上时，默认取字段名进行安装名称查找，如果注解写在setter方法上默认取属性名进行装配。当找不到与名称匹配的bean时才按照类型进行装 配。
	 * 但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。
	 * 
	 * 推荐使用@Resource注解在字段上，这样就不用写setter方法了.并且这个注解是属于J2EE的，减少了与Spring的耦合,这样代码看起就比较优雅 。
	 * 
	 * 另外，通过实践，还总结出一条规律：
	 * 如果将@requied或者@autowired写了set方法之上，则程序会走到set方法内部。
	 * 但如果写在了field之上，则不会进入set方法当中。
	 */
	@Resource
	private IUserDao userDao;
	@Resource
	public void setBaseDao(IUserDao userDao) {
		super.setBaseDao(userDao);
	}
	
	public boolean isExistByUsername(String username) {
		return userDao.isExistByUsername(username);
	}
}
