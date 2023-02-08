package org.iclass.controller.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.filter.SessionFilter;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;
import org.iclass.vo.NewMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 요청 매핑 : mapping.put(new RequestKeyValue("/community/read", "GET"), new ReadController() );
public class ReadController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(ReadController.class); 
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//지정된 idx 메인글 읽기
		String temp = request.getParameter("idx");			//메인글 글번호 파라미터로 받기
		long idx=0;
		HttpSession session = request.getSession();
		NewMember user = (NewMember)session.getAttribute("user");
		try {
			idx = Long.parseLong(temp);
		
		CommunityDao dao = CommunityDao.getInstance();
		
		dao.setReadCount(idx);
		Community vo = dao.selectByIdx(idx);
		if(vo==null) throw new RuntimeException();
		logger.debug(":::::: vo-{} :::::::");
		request.setAttribute("vo", vo);
		
		
		//idx 메인글의 댓글리스트를 애트리뷰트에 저장하기
		List<CommunityComments>cmtlist = dao.comments(idx);
		request.setAttribute("cmtlist", cmtlist);
		
		request.setAttribute("page", request.getParameter("page"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("read.jsp");
		dispatcher.forward(request, response);
		}catch (NumberFormatException e) {
			response.sendRedirect("list");	//NumberFormatException 처리
		}
	}

}
