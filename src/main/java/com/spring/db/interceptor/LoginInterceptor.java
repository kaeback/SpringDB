package com.spring.db.interceptor;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.debug("LoginInterceptor 실행");
		logger.debug(request.getRequestURI().toString());
		HttpSession session = request.getSession();
		HashMap<String, String> login_info = (HashMap<String, String>)session.getAttribute("login_info");
		
		if (login_info == null) {
			logger.debug("session is null");
			response.sendRedirect(request.getContextPath() + "/member/loginForm");
			
			return false;
		} else {
			logger.debug("session is not null");
			logger.debug(session.getAttribute("login_info").toString());
		}
		return super.preHandle(request, response, handler);
	}
}
