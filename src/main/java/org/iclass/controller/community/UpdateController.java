package org.iclass.controller.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

// 요청 매핑 :	mapping.put(new RequestKeyValue("/community/update","POST"), new UpdateController() );  
public class UpdateController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		long idx = Long.parseLong(request.getParameter("idx"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
//		System.out.println("idx" + idx);
//		System.out.println("title" + title);
//		System.out.println("content" + content);
//		System.out.println("ip" + ip);
		CommunityDao dao = CommunityDao.getInstance();
		Community vo =Community.builder()
				.title(title)
				.ip(ip)
				.content(content)
				.idx(idx)
				.build();
			
		int result = dao.update(vo);
//		System.out.println("result" + result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(result ==1) {
			response.sendRedirect("read?idx"+idx);
		}else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
