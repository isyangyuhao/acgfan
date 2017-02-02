package org.acg.shiro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.acg.entities.Admin;
import org.acg.entities.Permission;
import org.acg.service.admin.BaseAdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private BaseAdminService baseAdminService;
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
				
		//1.将AuthenticationInfo转换为UsernamePasswordToken
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		//2.从UsernamePasswordToken中获取username
		String username = usernamePasswordToken.getUsername();
		//3.调用数据库方法, 从数据库中查询username对应用户记录
		//4.如果用户不存在,则抛出UnKnownAccountException异常
		if (baseAdminService.getAdminByName(username).size() == 0) {
			throw new UnknownAccountException("用户不存在...");
		}
		@SuppressWarnings("unused")
		Admin admin = baseAdminService.getAdminByName(username).get(0);
		//5.根据用户信息情况,决定是否抛出其他异常(AuthenticationException)
//		if ("monster".equals("username")) {
//			throw new LockedAccountException("用户被锁定...");
//		}
		//6.根据用户情况来构建AuthenticationInfo并返回,通常使用实现类SimpleAuthenticationInfo
		//以下信息是从数据库中获取的
		//1)principal: 认证的实体信息,可以是username也可以是数据表对应的实体类对象
		Object principal = admin.getName();
		//2)credentials: 密码
		String credentials = admin.getPassword();
		//3)credentialsSalt: 盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(username + "360ABCCA5341962132E2E6204D7D88B2");
		//4)realmName: 当前Realm的name,调用父类的getName()方法即可
		String realmName = getName();
		//返回用户信息
		SimpleAuthenticationInfo info = new 
				SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		//1.通过PrincipalCollection中获取登录用户信息
		String principal = (String) arg0.getPrimaryPrincipal();
		//2.利用登录的用户信息来获取当前用户的角色或权限(用户信息本身自带/通过数据库查询)
//		Set<String> roles = new HashSet<>();
//		roles.add("user");
//		if ("admin".equals(principal)) {
//			roles.add("admin");
//		}
		//获取角色权限集合
		Set<Permission> permissions = 
				baseAdminService.getAdminByName(principal).get(0).getRole().getPermissions();
		Iterator<Permission> it = permissions.iterator();
		Set<String> roles = new HashSet<>();
		while (it.hasNext()) {
			String permissionName = it.next().getPermissionName();
			roles.add(permissionName);
		}
		//3.创建AuthorizationInfo,并这是roles属性
		AuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		//4.返回AuthorizationInfo对象
		return info;
	}
	
	//输出加密后的密码
	public static void main(String args []) {
		String hashAlgorithmName = "MD5";
		Object credentials = "root";
		ByteSource credentialsSalt = ByteSource.Util.bytes("root" + "360ABCCA5341962132E2E6204D7D88B2");
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
		System.out.println(result);
	}
	
}
