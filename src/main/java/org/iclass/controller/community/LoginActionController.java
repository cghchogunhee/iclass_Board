package org.iclass.controller.community;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.controller.Controller;
import org.iclass.dao.NewMemberDao;
import org.iclass.vo.NewMember;

public class LoginActionController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		//dao로 id,password 확인하는 메스드 실행
		//id,password 모두 admin 일 때 인증 성공으로 하는 예시
		NewMemberDao dao = NewMemberDao.getInstance();
		Map<String, String> map = new HashMap<>();
		
		map.put("id", id);
		map.put("password", password);
		
		NewMember vo = dao.login(map);
//		NewMember user = dao.selectOne(id);
		
		String url = request.getContextPath();
		String back = (String) session.getAttribute("back");
		session.removeAttribute("back");
		if(vo!=null) {
			//로그인 성공
			session.setAttribute("user",vo);
			if(back!=null)url=back;
		}else {
			url = "login?incorrect=y";
		}
		response.sendRedirect(url);
	}

}
