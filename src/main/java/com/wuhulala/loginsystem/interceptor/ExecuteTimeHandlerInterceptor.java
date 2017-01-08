/**
 * 
 */
package com.wuhulala.loginsystem.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author gery
 * @date 2012-11-20
 */
public class ExecuteTimeHandlerInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(ExecuteTimeHandlerInterceptor.class);
	
	private Long startExecuteTime = 0L;
	
	
	
	private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
	
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		startExecuteTime = System.currentTimeMillis();
		Enumeration<String> enu = request.getParameterNames();
		StringBuilder sb = new StringBuilder();
		while(enu.hasMoreElements()){  
			String paraName = (String)enu.nextElement();
			String value = request.getParameter(paraName);
			if("password".equals(paraName) || "repassword".equals(paraName) || paraName.contains("password")) {
				value = "********";
			}
			sb.append("&" + paraName + "=" + value + " ");
		}
		logger.info("Start ==>> Request IP:["+ getIpAddr(request) +"], Request URL:[" + request.getRequestURI() + "], Request Parameter:[" + sb.toString() + "]");
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(logger.isInfoEnabled()) {
			Long executeTime = System.currentTimeMillis() - startExecuteTime;
			logger.info("End ==>> " + request.getRequestURI() + ", execute time: " + executeTime + "ms");
		}
		
	}
	
}