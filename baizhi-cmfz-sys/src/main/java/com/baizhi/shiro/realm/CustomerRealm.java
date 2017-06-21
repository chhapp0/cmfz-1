package com.baizhi.shiro.realm;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *自定义realm
 */
public class CustomerRealm extends AuthorizingRealm {

	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("用户名====: "+token.getPrincipal());


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-basic.xml");


		AdminMapper adminMapper = (AdminMapper) context.getBean("adminMapper");

		System.out.println( token.getPrincipal());

		Admin login = adminMapper.selectByUserName( token.getPrincipal().toString());

		if(login!=null){
			return new SimpleAuthenticationInfo(login.getUsername(), login.getPassword(),
					ByteSource.Util.bytes(login.getSalt()),
					this.getName());
		}
		return null;
	}

}
