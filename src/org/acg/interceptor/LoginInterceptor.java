package org.acg.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 用户登录验证过滤器 <br>
 * 如果用户没用登录,则进行拦截返回首页
 * @author yangyuhao
 */
public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String, Object> sessionMap = arg0.getInvocationContext().getSession();
		if (sessionMap.get("user") != null) {
			arg0.invoke();
		}
		return "no-login";
	}
	
	
	
}
