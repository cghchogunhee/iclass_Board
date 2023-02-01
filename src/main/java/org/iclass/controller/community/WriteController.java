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
		CommunityDao dao = CommunityDao.getInstance();
		long result = dao.insert(Community.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.build()
				);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		if(result==1){
		out.print("alert('게시물을 등록했습니다');");
		}else{
		out.print("alert('게시물을 등록 실패했습니다');");
		}
		out.print("location.href='list'");
		out.print("</script>");
	}

}
