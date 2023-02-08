package org.iclass.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.vo.NewMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class); 
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//로그인이 되었을 때 접근할 수 없는 url 
		List<String> nosession = List.of("/member/join","/login","/test");
		//로그인을 해야 접근할 수 있는 url 
		List<String> logins = List.of("/community/update","/community/delete","/community/comments","/community/write");
		//List.of 메소드는 java9부터 사용 가능. 불변컬렉션(추가/삭제 못하는 리스트) 생성
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		logger.info(":::::::::요청 전 SessionFilter: {}:::::::::");
		HttpSession session = httpRequest.getSession();
		NewMember user = (NewMember)session.getAttribute("user");
		//로그인이 되었을 때(user != null) 접근할 수 없는 url. 또는 //로그인 안됐을때(user ==unll)
		if(nosession.contains(httpRequest.getServletPath())&&user !=null
				||logins.contains(httpRequest.getServletPath())&&user==null) {
			httpResponse.sendRedirect(httpRequest.getContextPath());
			return;
		}
		chain.doFilter(request, response);
		logger.info("::::::::::: 요청 후 SessionFilter: {}::::::::::");
	}

}
