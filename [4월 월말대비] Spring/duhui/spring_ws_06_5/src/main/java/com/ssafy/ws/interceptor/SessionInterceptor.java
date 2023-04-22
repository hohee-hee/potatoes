package com.ssafy.ws.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("loginUser") == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			
			RequestDispatcher disp = request.getRequestDispatcher("/");
			disp.forward(request, response);
			return false;
		}
		
		return true;
	}	
}
