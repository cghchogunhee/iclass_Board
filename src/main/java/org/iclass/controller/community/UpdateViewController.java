package org.iclass.controller.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.controller.RequestKeyValue;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.iclass.vo.NewMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 요청 매핑 :	mapping.put(new RequestKeyValue("/community/update","GET"), new UpdateViewController() );
public class UpdateViewController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(UpdateViewController.class); 
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정 화면으로 데이터 보내기
		CommunityDao dao = CommunityDao.getInstance();
		long idx = 0;
		Community vo =null;
		HttpSession session = request.getSession();
		NewMember user = (NewMember)session.getAttribute("user");
		try {
			idx = Long.parseLong(request.getParameter("idx"));
			vo = dao.selectByIdx(idx);
			request.setAttribute("vo", vo);
			if(vo==null||!vo.getWriter().equals(user.getId()))throw new RuntimeException();
			logger.debug(":::::: vo-{} :::::::");
			//현제페이지 read.jsp 에서 받아 update.jsp로 전달
			request.setAttribute("page", request.getParameter("page"));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("list");
		}
		
		
		
		
		
	}

}
