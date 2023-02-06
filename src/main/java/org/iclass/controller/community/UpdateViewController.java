package org.iclass.controller.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.controller.RequestKeyValue;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

// 요청 매핑 :	mapping.put(new RequestKeyValue("/community/update","GET"), new UpdateViewController() );
public class UpdateViewController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정 화면으로 데이터 보내기
		CommunityDao dao = CommunityDao.getInstance();
		long idx = 0;
		Community vo =null;
		idx = Long.parseLong(request.getParameter("idx"));
		vo = dao.selectByIdx(idx);
		request.setAttribute("vo", vo);
		
		//현제페이지 read.jsp 에서 받아 update.jsp로 전달
		request.setAttribute("page", request.getParameter("page"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
