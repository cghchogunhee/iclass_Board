package org.iclass.controller.community;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.icalss.dao.CommunityDao;

public class ListController implements Controller {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CommunityDao dao = CommunityDao.getInstance();
		/*
		 * List<Community>list = null;
		 * 
		 * list = dao.selectAll();
		 */
		request.setAttribute("list", dao.selectAll());
		//현제날짜시간 저장-출력형식 2개 중 하나 고를때 비교값 
		request.setAttribute("today", LocalDate.now());
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
		
	}

}
