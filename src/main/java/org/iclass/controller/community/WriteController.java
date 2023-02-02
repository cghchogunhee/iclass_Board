package org.iclass.controller.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.icalss.dao.CommunityDao;
import org.iclass.vo.Community;

public class WriteController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		CommunityDao dao = CommunityDao.getInstance();
		long result = dao.insert(Community.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.ip(ip)
				.build()
				);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
	//	PrintWriter out = response.getWriter();
//		out.print("<script>");
		if(result!=0){
	//	out.print("alert('게시물을 등록했습니다');");
		response.sendRedirect("list");
		}else{
//		out.print("alert('게시물을 등록 실패했습니다');");
		response.sendRedirect(request.getContextPath());	//메인화면으로 이동
		}
//		out.print("</script>");
	}

}
